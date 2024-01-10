package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String fromUserName;
    private String toUserName;
    private double amount;
}
