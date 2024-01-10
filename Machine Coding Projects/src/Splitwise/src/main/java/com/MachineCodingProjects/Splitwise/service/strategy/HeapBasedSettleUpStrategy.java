package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service.strategy;

import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.dto.TransactionDTO;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.Expense;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.User;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.UserExpense;

import java.util.*;

public class HeapBasedSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<TransactionDTO> settleUp(List<Expense> expenses){
        HashMap<User, Double> outStandingAmountMap = new HashMap<>();
        List<TransactionDTO> transactions = new ArrayList<>();
        for(Expense expense: expenses){
            for(UserExpense userExpense : expense.getUserExpenses()){
                User user = userExpense.getUser();
                double currentOutStandingAmount = outStandingAmountMap.getOrDefault(user, 0.00);
                outStandingAmountMap.put(user, getUpdatedOutStandingAmount(currentOutStandingAmount, userExpense));
            }
        }

        PriorityQueue<Map.Entry<User, Double>> maxHeap = new PriorityQueue<>(
                (a,b) -> Double.compare(b.getValue(), a.getValue())
        );

        PriorityQueue<Map.Entry<User, Double>> minHeap = new PriorityQueue<>(
                Comparator.comparingDouble(Map.entry::getValue)
        );

        for(Map.Entry<User, Double> entry : outStandingAmountMap.entrySet()){
            if(entry.getValue() < 0){
                minHeap.add(entry);
            } else if(entry.getValue() > 0){
                maxHeap.add(entry);
            } else {
                System.out.println(entry.getKey().getName() + "'s is already settled up");
            }
        }

        while(!minHeap.isEmpty()){
            Map.Entry<User, Double> maxHasToPay = minHeap.poll();
            Map.Entry<User, Double> maxWilGetPaid = maxHeap.poll();
            TransactionDTO transactionDTO = new TransactionDTO(
                    maxHasToPay.getKey().getName(),
                    maxWillGetPaid.getKey().getName(),
                    Math.min(Math.abs(maxHasToPay.getValue()), maxWilGetPaid.getValue())
            );
            transactions.add(transactionDTO);

            double newBalance = maxHasToPay.getValue() + maxWilGetPaid.getValue();
            if(newBalance == 0){
                System.out.println("Settled for: " + maxHasToPay.getKey().getName() + ", add " + maxWilGetPaid.getKey().getName());
            } else if(newBalance < 0){
                maxHasToPay.setValue(newBalance);
                minHeap.add(maxHasToPay);
            } else if(newBalance > 0){
                maxWillGetPaid.setValue(newBalance);
                maxHeap.add(maxWillGetPaid);
            }
        }
        return transactions;
    }

    private double getUpdatedOutStandingAmount(double currentOutStandingAmount, UserExpense userExpense){
        if(userExpense.getUserExpenseType().equals(UserExpenseType.ADD)){
            currentOutStandingAmount = currentOutStandingAmount + userExpense.getAmount();
        } else{
            currentOutStandingAmount = currentOutStandingAmount - userExpense.getAmount();
        }
        return currentOutStandingAmount;
    }
}
