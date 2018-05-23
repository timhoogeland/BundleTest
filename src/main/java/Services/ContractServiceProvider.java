package Services;

public class ContractServiceProvider {
	private static ContractService contractService = new ContractService();
	
	public static ContractService getContractService(){
		return contractService;
	}
}
