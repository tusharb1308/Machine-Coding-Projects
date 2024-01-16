package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.dto;

import BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models.Ticket;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private int responseCode;
    private String responseMessage;
    private List<Ticket> tickets;
}
