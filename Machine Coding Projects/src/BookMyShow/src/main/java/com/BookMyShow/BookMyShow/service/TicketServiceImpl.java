package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.service;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.ShowSeatNotAvailableException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.TicketNotFoundException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.UserNotFoundException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.*;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository.ShowRepository;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository.ShowSeatRepository;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository.TicketRepository;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId){
        User bookedByUser = userRepository.findById(userId).get();
        Show show = showRepository.findById(showId).get();

        for(Long showSeatId: showSeatIds){
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            } else{
                throw new ShowSeatNotAvailableException("Show seat not available");
            }
            showSeatRepository.save(showSeat);
        }

        boolean paymentDone = paymentCheck();
        List<ShowSeat> showSeats = new ArrayList<>();
        double amount = 0;
        if(paymentDone){
            for(Long showSeatId: showSeatIds){
                ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeat = showSeatRepository.save(showSeat);
                showSeats.add(showSeat);
                amount = amount + showSeat.getPrice();
            }
        }

        return ticketGenerator(bookedByUser, show, showSeats, amount);
    }

    @Override
    public Ticket cancelTicket(Long ticketId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("Ticket for given ID is not found");
        }

        Ticket ticket = ticketOptional.get();
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        for(ShowSeat showSeat: ticket.getShowSeats()){
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(showSeat);
        }
        ticketRepository.save(ticket);

        for(Payment p: ticket.getPayments()){
            p.getRefNo();
        }
        return ticket;
    }

    @Override
    public Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if(ticketOptional.isEmpty()){
            throw new TicketNotFoundException("ticket for given id is not found");
        }

        Optional<User> fromUserOptional = userRepository.findById(fromUserId);
        Optional<User> toUserOptional = userRepository.findById(toUserId);

        if(fromUserOptional.isEmpty() || toUserOptional.isEmpty()){
            throw new UserNotFoundException("user details given for ticket transfer is not found");
        }

        Ticket ticket = ticketOptional.get();
        User fromUser = fromUserOptional.get();

        List<Ticket> bookedTicketHistory = fromUser.getTickets();
        bookedTicketHistory.remove(ticket);
        userRepository.save(fromUser);

        User toUser = toUserOptional.get();
        bookedTicketHistory = toUser.getTicets();
        bookedTicketHistory.add(ticket);
        toUser = userRepository.save(toUser);

        ticket.setUser(toUser);
        return ticketRepository.save(ticket);
    }

    private boolean paymentCheck(){
        return true;
    }

    private Ticket ticketGenerator(User user, Show show, List<ShowSeat> showSeats, double amount){
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setAmount(amount);
        ticket.setBookedAt(LocalDateTime.now());
        ticket.setBookingStatus(BookingStatus.CONFIRMED);

        return ticketRepository.save(ticket);
    }
}
