package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.ShowSeat;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
    @Override
    Optional<ShowSeat> findById(Long showSeatId);
    @Override
    ShowSeat save(ShowSeat showSeat);
}
