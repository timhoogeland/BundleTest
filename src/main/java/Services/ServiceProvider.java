package Services;

public class ServiceProvider {
    private static UserService userService = new UserService();
    private static ContractService contractService = new ContractService();
    private static AddressService adressService = new AddressService();
    
    
    public static UserService getUserService() { return userService; }
    public static ContractService getContractService() { return contractService; }
    public static AddressService getAdressService() { return adressService; }
}
