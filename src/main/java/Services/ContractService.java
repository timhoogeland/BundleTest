package Services;

import java.util.List;

import DAOS.ContractDAO;
import Objects.Contract;

public class ContractService {
	    private ContractDAO contract = new ContractDAO();

	    public ContractService() {}

	    public List<Contract> getAllContracts() { return contract.findAll(); }

	    public Contract getContractByID(int id) { 
	    	return contract.findByID(id); 
	    }
	    
	    public List<Contract> getContractsByFK(int id) { 
	    	return contract.findContractsByUserIDFK(id);
	    }
	    
//	    public Contract update (Contract contract) { return contractDAO.update(contract); }
//
//	    public boolean delete (Contract contract) { return contractDAO.delete(contract); }

	    public boolean newContract (Contract newContract) {
	    	return contract.newContract(newContract); 
	    }
}

