package Objects;

import java.sql.Date;

public class Loan {
	private int loanId;
	private int amount;
	private String status;
	private Date startDate;
	private int duration;
	private Date closingDate;
	private String loanType;
	private int contractId;
	
	public Loan(int loanId, int amount, String status, Date startDate, int duration, Date closingDate, String loanType, int contractId){
		this.loanId = loanId;
		this.amount = amount;
		this.status = status;
		this.startDate = startDate;
		this.duration = duration;
		this.closingDate = closingDate;
		this.loanType = loanType;
		this.contractId = contractId;
	}

	public int getLoanId() {
		return loanId;
	}
	public int getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public int getDuration() {
		return duration;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public String getLoanType() {
		return loanType;
	}
	public int getContractId() {
		return contractId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	
	
}
