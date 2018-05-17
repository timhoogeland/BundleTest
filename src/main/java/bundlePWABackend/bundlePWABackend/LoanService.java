package bundlePWABackend.bundlePWABackend;

import java.util.List;

public class LoanService {
LoanDAO Loan = new LoanDAO();
	
	public List<Loan> getAllLoans() {
		return Loan.findAll();
	}
}
