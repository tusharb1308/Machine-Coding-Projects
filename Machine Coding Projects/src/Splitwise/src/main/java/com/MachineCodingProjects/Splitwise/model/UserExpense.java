package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model;

@Getter
@Setter
@Entity(name = "SPLITWISE_USEREXPENSE")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}
