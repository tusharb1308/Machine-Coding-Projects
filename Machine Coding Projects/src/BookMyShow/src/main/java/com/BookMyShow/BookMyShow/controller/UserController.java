package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.controller;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.controller.utils.UserControllerUtil;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.dto.UserSignUpRequestDTO;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.dto.UserSignUpResponseDTO;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.User;
import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService; // interface

    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO){
        User user;
        UserSignUpResponseDTO responseDTO = new UserSignUpResponseDTO();
        try{
            UserControllerUtil.validateUserSignUPRequestDTO(userSignUpRequestDTO);
            user = userService.signUp(userSignUpRequestDTO.getName(), userSignUpRequestDTO.getEmail(), userSignUpRequestDTO.getPassword());
            // method that converts internal models into DTOs
            responseDTO.setId(user.getId());
            responseDTO.setName(user.getName());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setTickets(user.getTickets());
            responseDTO.setResponseCode(200);
            responseDTO.setResponseMessage("SUCCESS");
            return responseDTO;
        } catch(Exception e){
            responseDTO.setResponseCode(500);
            responseDTO.setResponseMessage("internal server error");
            return responseDTO;
        }
    }
}
