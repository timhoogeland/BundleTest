package Services;

import java.util.List;

import DAOS.LoanGroupDAO;
import Objects.Group;
import Objects.LoanGroup;



public class LoanGroupService {
LoanGroupDAO loanGroup = new LoanGroupDAO();
	
	public List<LoanGroup> getAllLoanGroupsByLoanOfficer(int loanofficerId) {
		return loanGroup.getAllLoanGroupsByLoanOfficer(loanofficerId);
	}

	public List<LoanGroup> getAllLoanGroups() {
		return loanGroup.getAllGroups();
	}
}
