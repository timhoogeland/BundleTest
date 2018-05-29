package Services;

import java.util.List;

import DAOS.LoanGroupDAO;
import Objects.Group;
import Objects.LoanGroup;



public class LoanGroupService {
LoanGroupDAO loanGroupDAO = new LoanGroupDAO();
	
	public List<LoanGroup> getAllLoanGroupsByLoanOfficer(int loanofficerId) {
		return loanGroupDAO.getAllLoanGroupsByLoanOfficer(loanofficerId);
	}

	public List<LoanGroup> getAllLoanGroups() {
		return loanGroupDAO.getAllLoanGroups();
	}

	public List<LoanGroup> getLoanGroupById(int groupId) {
		return loanGroupDAO.getLoanGroupById(groupId);
	}
}
