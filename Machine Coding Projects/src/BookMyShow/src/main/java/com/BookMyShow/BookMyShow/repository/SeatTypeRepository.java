package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.SeatType;

import java.util.Optional;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long>{
    @Override
    Optional<SeatType> findById(Long showId);
    @Override
    SeatType save(SeatType show);
}
