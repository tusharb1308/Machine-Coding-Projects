package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Override
    Optional<User> findById(Long userId);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndName(String email, String name);
    User save(User user);
}
