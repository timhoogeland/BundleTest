package bundlePWABackend.bundlePWABackend;

import java.util.List;

import persistence.UserDAO;

public class UserService {
	    private UserDAO userDAO = new UserDAO();

	    public UserService() {}

	    public List<User> getAllAccounts() { return userDAO.findAll(); }

	    public User getAccountByID(int id) { return userDAO.findByID(id); }
	    
	    public int getIdByEmail(String name) { return userDAO.findIdByName(name); }

	    public User update (User user) { return userDAO.update(user); }

	    public boolean delete (User user) { return userDAO.delete(user); }

	    public User addAccount (User user) { return userDAO.save(user); }
}
