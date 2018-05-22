package Services;

import java.util.List;

import DAOS.GroupDAO;
import Objects.Group;
import Objects.LoanGroup;



public class GroupService {
GroupDAO group = new GroupDAO();
	
	public List<LoanGroup> getAllGroups(int loanofficerId) {
		return group.getAllGroups(loanofficerId);
	}
	
	public List<Group> getGroupById(int groupId){
		return group.getGroupById(groupId);
	}
}
