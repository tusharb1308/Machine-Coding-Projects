package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatre;
}
