package Services;

import java.util.List;

import DAOS.UserDAO;
import Objects.User;

public class UserService {
	    private UserDAO userDAO = new UserDAO();

	    public UserService() {}

	    public List<User> getAllUsers() { return userDAO.findAll(); }

	    public User getUserByID(int id) { return userDAO.findByID(id); }
	    
	    public int getIdByEmail(String name) { return userDAO.findIdByName(name); }

	    public User update (User user) { return userDAO.update(user); }

	    public boolean delete (User user) { return userDAO.delete(user); }

	    public User newUser (User user) { return userDAO.save(user); }
}
