package Services;

import java.util.List;

import DAOS.UserDAO;
import Objects.User;
import Objects.UserLoanInformation;

public class UserService {
	    private UserDAO userDAO = new UserDAO();

	    public UserService() {}

	    public List<User> getAllUsers() { 
	    	return userDAO.findAll(); 
	    	}

	    public User getUserByID(int id) { 
	    	return userDAO.findById(id); 
	    	}
	    
	    public int getIdByEmail(String name) { 
	    	return userDAO.findIdByName(name); 
	    	}

	    public User update (User user) { 
	    	return userDAO.update(user); 
	    	}

	    public boolean delete (int userId) { 
	    	return userDAO.delete(userId); 
	    	}

	    public User newUser (User user) { 
	    	return userDAO.save(user); 
	    	}
	    public List<UserLoanInformation> getUserLoanInformation(int userId){
	    	return userDAO.getUserLoanInformation(userId);
	    }
}
