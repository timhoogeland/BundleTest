package Services;

public class LoanServiceProvider {
	private static LoanService loanService= new LoanService();

	public static LoanService getLoanService() {
		return loanService;
	}
}
