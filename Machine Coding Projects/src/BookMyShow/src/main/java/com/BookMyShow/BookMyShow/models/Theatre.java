package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}
