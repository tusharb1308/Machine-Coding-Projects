package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    private String posterLink;
}
