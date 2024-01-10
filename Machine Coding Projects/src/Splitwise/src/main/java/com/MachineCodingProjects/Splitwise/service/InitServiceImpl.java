package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service;

import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.Group;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.User;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.UserExpense;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.repository.ExpenseRepository;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.repository.GroupRepository;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.repository.UserExpenseRepository;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.repository.UserRepository;

import javax.swing.*;
import java.util.Currency;

@Service
public class InitServiceImpl implements InitService{
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    pubic void initialise(){
        Group group = new Group();
        group.setName("Go Goa Gone");
        group.setDescription("Goa trip that will not happen");
        group.setDefaultCurrency(Currency.INR);
        Group savedGroup = groupRepository.save(group);

        User a = User.builder().name("A").email("a@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User b = User.builder().name("B").email("b@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User c = User.builder().name("C").email("c@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User d = User.builder().name("D").email("d@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User e = User.builder().name("E").email("e@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User f = User.builder().name("F").email("f@gmail.com").phoneNumber("123").groups(List.of(savedGroup)).build();

        User savedUserA = userRepository.save(a);
        User savedUserB = userRepository.save(b);
        User savedUserC = userRepository.save(c);
        User savedUserD = userRepository.save(d);
        User savedUserE = userRepository.save(e);
        User savedUserF = userRepository.save(f);

        savedGroup.setUsers(List.of(savedUserA, savedUserB, savedUserC, savedUserD, savedUserE, savedUserF));
        savedGroup = groupRepository.save(savedGroup);

        UserExpense userExpenseA = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserA);
        UserExpense savedUserExpenseA = userExpenseRepository.save(userExpenseA);

        UserExpense userExpenseB = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserB);
        UserExpense savedUserExpenseB = userExpenseRepository.save(userExpenseB);

        UserExpense userExpenseC = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserC);
        UserExpense savedUserExpenseC = userExpenseRepository.save(userExpenseC);

        UserExpense userExpenseD = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserD);
        UserExpense savedUserExpenseD = userExpenseRepository.save(userExpenseD);

        UserExpense userExpenseE = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserE);
        UserExpense savedUserExpenseE = userExpenseRepository.save(userExpenseE);

        UserExpense userExpenseF = new UserExpense();
        userExpenseA.setUserExpenseType(UserExpenseType.HADTOPAY);
        userExpenseA.setAmount(500);
        userExpenseA.setUser(savedUserF);
        UserExpense savedUserExpenseF = userExpenseRepository.save(userExpenseF);

        Expense expense = new Expense();
        expense.setDescription("Total trip expense");
        expense.setAmount(1000);
        expense.setUserExpenses(List.of(savedUserExpenseA, savedUserExpenseB, savedUserExpenseC, savedUserExpenseD, savedUserExpenseE, savedUserExpenseF));
        expense.setCurrency(Currency.INR);
        Expense savedExpense = expenseRepository.save(expense);

        savedGroup.setExpenses(List.of(savedExpense));
        groupRepository.save(savedGroup);
    }

}
