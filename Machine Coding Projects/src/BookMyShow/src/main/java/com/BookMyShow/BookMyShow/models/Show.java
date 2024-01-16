package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @OneToMany
    private List<ShowSeat> showSeats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCOllection
    private List<Feature> features;
}
