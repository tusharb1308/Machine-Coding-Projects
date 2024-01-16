package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
    @ManyToOne
    private Seat seat;
    private double price;
}
