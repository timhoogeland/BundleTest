package Objects;

import java.sql.Date;

public class Loan {
private int loanId;
private String loanType;
private int amount;
private String status;
private Date startDate;
private int duration;
private Date closingDate;
private int paidAmount;
private String contractPdf;
private String description;
private int userIdFk;


public Loan(int loanId, String loanType, int amount, String status, Date startDate, int duration, Date closingDate, int paidAmount, String contractPdf, String description, int userIdFk) {
	this.loanId = loanId;
	this.loanType = loanType;
	this.amount = amount;
	this.status = status;
	this.startDate = startDate;
	this.duration = duration;
	this.setClosingDate(closingDate);
	this.paidAmount = paidAmount;
	this.contractPdf = contractPdf;
	this.setDescription(description);
	this.userIdFk = userIdFk;
}


public int getLoanId() {
	return loanId;
}


public String getLoanType() {
	return loanType;
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


public int getPaidAmount() {
	return paidAmount;
}


public String getContractPdf() {
	return contractPdf;
}


public String getDescription() {
	return description;
}


public int getUserIdFk() {
	return userIdFk;
}


public void setLoanId(int loanId) {
	this.loanId = loanId;
}


public void setLoanType(String loantype) {
	this.loanType = loantype;
}


public void setAmount(int amount) {
	this.amount = amount;
}


public void setStatus(String status) {
	this.status = status;
}


public void setStartDate(Date startdate) {
	this.startDate = startdate;
}


public void setDuration(int duration) {
	this.duration = duration;
}


public void setClosingDate(Date closingdate) {
	this.closingDate = closingdate;
}


public void setPaidAmount(int paidAmount) {
	this.paidAmount = paidAmount;
}


public void setContractPdf(String contractPdf) {
	this.contractPdf = contractPdf;
}


public void setDescription(String description) {
	if (description != null){
		this.description = description;
	}else{
		this.description = "";
	}
}


public void setUserIdFk(int userIdFk) {
	this.userIdFk = userIdFk;
}
}
