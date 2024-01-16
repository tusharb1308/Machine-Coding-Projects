package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.service;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.InvalidCredentialException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.UserAlreadyExistsException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.exception.UserNotFoundException;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.User;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.repository.UserRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("user with given email does not exist: " + email);
        }

        User user = userOptional.get();
        if(user.getPassword().equals(password)){
            return user;
        } else{
            throw new InvalidCredentialException("credentials are invalid");
        }
    }

    @Override
    public User signUp(String name, String email, String password){
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException("user with given email is already present");
        }

        User newUser = new User();
        newUser.setPassword(password);
        newUser.setName(name);
        newUser.setEmail(email);

        return userRepository.save(newUser);
    }
}
