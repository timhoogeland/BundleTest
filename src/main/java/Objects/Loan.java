package bundlePWABackend.bundlePWABackend;

import java.util.Date;

public class Loan {
private int loanId;
private int amount;
private String status;
private String startdate;
private int duration;
private String closingdate;
private String loantype;
private int contractId;


public Loan(int loanId, int amount, String status, String startdate, int duration, String closingdate, String loantype,int contractId) {
	super();
	this.loanId = loanId;
	this.amount = amount;
	this.status = status;
	this.startdate = startdate;
	this.duration = duration;
	this.closingdate = closingdate;
	this.loantype = loantype;
	this.contractId = contractId;
}
public int getLoanId() {
	return loanId;
}
public void setLoanId(int loanId) {
	this.loanId = loanId;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getStartdate() {
	return startdate;
}
public void setStartdate(String startdate) {
	this.startdate = startdate;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getClosingdate() {
	return closingdate;
}
public void setClosingdate(String closingdate) {
	this.closingdate = closingdate;
}
public String getLoantype() {
	return loantype;
}
public void setLoantype(String loantype) {
	this.loantype = loantype;
}
public int getcontractId() {
	return contractId;
}
public void setcontractId(int contractId) {
	this.contractId = contractId;
}


}
