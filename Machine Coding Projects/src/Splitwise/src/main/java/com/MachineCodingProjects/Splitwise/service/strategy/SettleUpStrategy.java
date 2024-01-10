package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service.strategy;

public interface SettleUpStrategy {
    List<TransactionDTO> settleUp(List<Expense> expenses);
}
