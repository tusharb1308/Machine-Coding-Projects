package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP")
public class Group extends BaseModel{
    private String name;
    private String description;
    private double totalAmountSpent;
    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;
    @OneToMany
    @JoinColumn(name = "splitwise_group_id")
    private List<Expense> expenses;
    @ManyToMany
    private List<User> users;
}
