package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service;

import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.dto.TransactionDTO;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException;
}
