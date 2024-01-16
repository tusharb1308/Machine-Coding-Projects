package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int name;
    private int colVal;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
}
