package DAO;

public class Main {

	public static void main(String[] args) {
		loanDAO dao = new loanDAO();
		System.out.println(dao.selectLoan("select * from public." + '"' + "Group" + '"'));
	}

}
