package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    @Override
    Optional<Ticket> findById(Long ticketId);
    @Override
    Ticket save(Ticket ticket);
}
