package bundlePWABackend.bundlePWABackend;

public class LoanServiceProvider {
	private static LoanService loanService= new LoanService();

	public static LoanService getMedewerkerService() {
		return loanService;
	}
}
