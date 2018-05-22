package Services;

import java.util.List;

import DAOS.ContractDAO;
import Objects.Contract;

public class ContractService {
	    private ContractDAO contractDAO = new ContractDAO();

	    public ContractService() {}

	    public List<Contract> getAllContracts() { return contractDAO.findAll(); }

	    public Contract getContractByID(int id) { return contractDAO.findByID(id); }
	    
	    public List<Contract> getContractsByFK(int id) { return contractDAO.findContractsByUserIDFK(id);}
	    
//	    public Contract update (Contract contract) { return contractDAO.update(contract); }
//
//	    public boolean delete (Contract contract) { return contractDAO.delete(contract); }

	    public Contract addContract (Contract contract) { return contractDAO.save(contract); }
}

