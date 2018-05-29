package Services;

import java.util.List;

import DAOS.LoanGroupDAO;
import Objects.Group;
import Objects.LoanGroup;
import Objects.LoanGroupInformation;



public class LoanGroupService {
LoanGroupDAO loanGroupDAO = new LoanGroupDAO();
	
	public List<LoanGroupInformation> getAllLoanGroupsByLoanOfficer(int loanofficerId) {
		return loanGroupDAO.getAllLoanGroupsByLoanOfficer(loanofficerId);
	}

	public List<LoanGroup> getAllLoanGroups() {
		return loanGroupDAO.getAllLoanGroups();
	}

	public List<LoanGroup> getLoanGroupById(int groupId) {
		return loanGroupDAO.getLoanGroupById(groupId);
	}
}
