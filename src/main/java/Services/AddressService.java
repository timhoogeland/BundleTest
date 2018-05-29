package Services;

import java.util.List;

import DAOS.AddressDAO;
import Objects.Adress;

public class AddressService {
	private AddressDAO addressDAO = new AddressDAO();

    public AddressService() {}

    public List<Adress> getAllAdresses() {
    	return addressDAO.findAll();
    	}

    public Adress getAdressByID(int addressId) { 
    	
    	return addressDAO.findById(addressId); 
    	}

    public boolean deleteAdress (int addressId) { 
    	return addressDAO.deleteAddress(addressId); 
    	}
    
      public Adress newAddress (Adress address) { 
    	  return addressDAO.newAddress(address); }

	public Adress updateAddress(Adress updateAddress) {
		return addressDAO.update(updateAddress);
	}
}
