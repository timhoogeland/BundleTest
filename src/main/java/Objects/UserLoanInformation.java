package Objects;

public class UserLoanInformation {
	public int loanOfficerId;
	public int loanId;
	public int groupId;
	
	public UserLoanInformation(int loanOfficerId, int LoanId, int groupId){
		this.setGroupId(groupId);
		this.setLoanId(LoanId);
		this.setLoanOfficerId(loanOfficerId);
	}
	
	public int getLoanOfficerId() {
		return loanOfficerId;
	}
	public int getLoanId() {
		return loanId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setLoanOfficerId(int loanOfficerId) {
		this.loanOfficerId = loanOfficerId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
