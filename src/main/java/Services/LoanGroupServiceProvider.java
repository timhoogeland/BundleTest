package Services;

public class LoanGroupServiceProvider {
	private static LoanGroupService loanGroupService= new LoanGroupService();

	public static LoanGroupService getLoanGroupService() {
		return loanGroupService;
	}
}
