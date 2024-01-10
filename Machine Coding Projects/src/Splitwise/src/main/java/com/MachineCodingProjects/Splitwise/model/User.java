package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgConstructor
@AllArgsConstructor
@Entity(name = "SPLITWISE_USER")
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
}
