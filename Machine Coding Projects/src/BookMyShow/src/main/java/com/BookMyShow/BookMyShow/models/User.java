package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> tickets;
}
