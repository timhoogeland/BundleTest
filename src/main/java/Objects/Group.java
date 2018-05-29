package Objects;

public class Group {
	public int userId;
	public int loanId;
	public String firstname;
	public String lastname;
	public int loanOfficerId;
	public int groupId;
	
	public Group(int userId, int loanId, String firstname, String lastname, int loanOfficerId, int groupId){
		this.userId = userId;
		this.loanId = loanId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.loanOfficerId = loanOfficerId;
		this.groupId = groupId;
	}
	public int getLoanOfficerId() {
		return loanOfficerId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setLoanOfficerId(int loanOfficerId) {
		this.loanOfficerId = loanOfficerId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
