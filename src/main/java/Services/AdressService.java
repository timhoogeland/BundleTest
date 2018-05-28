package Services;

import java.util.List;

import DAOS.AdressDAO;
import Objects.Adress;

public class AdressService {
	private AdressDAO adressDAO = new AdressDAO();

    public AdressService() {}

    public List<Adress> getAllAdresses() { return adressDAO.findAll(); }

    public Adress getAdressByID(int id) { return adressDAO.findByID(id); }
//    
//    public List<Adress> getContractsByFK(int id) { return adressDAO.findAdresssByUserIDFK(id);}
    
//    public Contract update (Contract contract) { return contractDAO.update(contract); }
//
//    public boolean delete (Contract contract) { return contractDAO.delete(contract); }
    
      public Adress addContract (Adress adress) { return adressDAO.newAddress(adress); }
}
