package Services;

public class ServiceProvider {
    private static UserService userService = new UserService();
    private static ContractService contractService = new ContractService();
    private static AdressService adressService = new AdressService();
    
    
    public static UserService getUserService() { return userService; }
    public static ContractService getContractService() { return contractService; }
    public static AdressService getAdressService() { return adressService; }
}
