package Services;

import java.util.List;

import DAOS.LoanGroupDAO;
import Objects.Group;
import Objects.LoanGroup;



public class LoanGroupService {
LoanGroupDAO loanGroup = new LoanGroupDAO();
	
	public List<LoanGroup> getAllGroups(int loanofficerId) {
		return loanGroup.getAllGroups(loanofficerId);
	}
}
