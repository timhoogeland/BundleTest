package Objects;

public class Group {
	public int userId;
	public int loanId;
	
	public Group(int userId, int loanId){
		this.userId = userId;
		this.loanId = loanId;
	}
	public int getUserId() {
		return userId;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
}
