package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service;

import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.dto.TransactionDTO;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.exception.GroupNotFoundException;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.model.Group;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.repository.GroupRepository;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service.strategy.SettleUpStrategy;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service.strategy.SettleUpStrategyFactory;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException {
        SettleUpStrategy strategy = SettleUpStrategyFactory.getSettleUpStrategy();
        Optional<Group> savedGroup = groupRepository.findById(groupId);
        if(savedGroup.isEmpty()){
            throw new GroupNotFoundException("Group for the given ID was not found. ID: " + groupId);
        }
        return strategy.settleUp(savedGroup.get().getExpenses());
    }
}
