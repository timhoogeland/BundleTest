package PdfGenerator;

public class RetrieveData {
	private Object user;
	private Object adress;
	private Object loan;
	public void setUserData(Object userData){
		user = userData;
		System.out.println(userData.toString());
	}
	public Object getUserData(){
		return user;
	}
	public void setAdresData(Object adressData){
		adress = adressData;
	}
	public Object getAdressData(){
		return adress;
	}
	public void setLoanData(Object loanData){
		loan = loanData;
	}
	public Object getLoanData(){
		return loan;
	}
}
