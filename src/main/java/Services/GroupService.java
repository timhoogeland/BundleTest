package Services;

import java.util.List;

import DAOS.GroupDAO;
import Objects.Group;



public class GroupService {
GroupDAO group = new GroupDAO();
	
	public List<Group> getAllGroups(int id) {
		return group.selectGroup(id);
	}
}
