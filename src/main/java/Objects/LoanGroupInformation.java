package Objects;

public class LoanGroupInformation {
	public String firstname;
	public String lastname;
	public int userId;
	public int paidAmount;
	public int amount;
	public int loanId;
	public int groupId;
	
	public LoanGroupInformation(String firstname, String lastname, int userId, int paidAmount, int amount, int loanId, int groupId){
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setUserId(userId);
		this.setPaidAmount(paidAmount);
		this.setAmount(amount);
		this.setLoanId(loanId);
		this.setGroupId(groupId);
	}
	
	public int getGroupId() {
		return groupId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getUserId() {
		return userId;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public int getAmount() {
		return amount;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
