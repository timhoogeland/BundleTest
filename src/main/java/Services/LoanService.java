package Services;

import java.util.List;

import DAOS.loanDAO;
import Objects.Loan;

public class LoanService {
loanDAO Loan = new loanDAO();
	
	public List<Loan> getAllLoans() {
		return Loan.selectLoan();
	}
}
