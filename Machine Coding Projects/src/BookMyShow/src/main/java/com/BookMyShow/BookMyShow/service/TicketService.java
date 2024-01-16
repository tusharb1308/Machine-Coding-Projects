package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.service;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);
    Ticket cancelTicket(Long ticketId);
    Ticket transferTicket(Long ticketId, Long fromUserId, Long toUserId);
}
