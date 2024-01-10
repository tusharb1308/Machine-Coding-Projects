package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model;

import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_EXPENSE")
public class Expense extends BaseModel{
    private double Amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @OneToMany
    @JoinColumn(name = "Splitwise_expense_id")
    private List<UserExpense> userExpenses;
}
