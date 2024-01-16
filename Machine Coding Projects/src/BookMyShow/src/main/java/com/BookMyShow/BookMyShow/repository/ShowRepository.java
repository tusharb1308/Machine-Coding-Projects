package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.Show;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long>{
    @Override
    Optional<Show> findById(Long showId);
    @Override
    Show save(Show show);
}
