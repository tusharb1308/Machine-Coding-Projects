package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.service;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.User;

public interface UserService {
    User login(String email, String password);
    User signUp(String name, String email, String password);
}
