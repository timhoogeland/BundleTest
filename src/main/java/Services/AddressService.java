package Services;

import java.util.List;

import DAOS.AddressDAO;
import Objects.Adress;

public class AddressService {
	private AddressDAO addressDAO = new AddressDAO();

    public AddressService() {}

    public List<Adress> getAllAdresses() { return addressDAO.findAll(); }

    public Adress getAdressByID(int id) { return addressDAO.findByID(id); }
//    
//    public List<Adress> getContractsByFK(int id) { return adressDAO.findAdresssByUserIDFK(id);}
    
//    public Contract update (Contract contract) { return contractDAO.update(contract); }
//
//    public boolean delete (Contract contract) { return contractDAO.delete(contract); }
    
      public Adress addAddress (Adress adress) { 
    	  return addressDAO.newAddress(adress); }

	public Adress updateAddress(Adress updateAddress) {
		return addressDAO.update(updateAddress);
	}
}
