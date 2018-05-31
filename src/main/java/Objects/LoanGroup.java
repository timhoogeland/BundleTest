package Objects;

public class LoanGroup {
	private int groupId;
	private int loanId;

	public LoanGroup(int id, int loanId) {
		this.groupId = id;
		this.setLoanId(loanId);
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int id) {
		this.groupId = id;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
}
