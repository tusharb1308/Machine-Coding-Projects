package Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.controller;

import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.dto.TransactionDTO;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.exception.GroupNotFoundException;
import Splitwise.src.main.java.com.MachineCodingProjects.Splitwise.service.GroupService;
//import org.springframework.http.ResponseEntity;

import java.util.List;

@RestContoller
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/settleUp/{groupId}")
    public ResponseEntity settleUpForGroup(@PathVariable("groupId") int groupId) throws GroupNotFoundException{
        List<TransactionDTO> transactions = groupService.settleUpByGroupId(groupId);
        return ResponseEntity.ok(transactions);
    }
}
