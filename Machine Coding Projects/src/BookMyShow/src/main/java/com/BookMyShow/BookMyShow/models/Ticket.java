package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    @ManyToOne
    private List<ShowSeat> showSeats;
    private LocalDateTime bookedAt;
    private double amount;
}
