package Services;
import java.util.List;

import DAOS.LoginDAO;
import bundlePWABackend.bundlePWABackend.Login;

public class LoginService {
LoginDAO login = new LoginDAO();
	public List<Login> getUserID(String username, String password) {
		return login.login(username, password);
	}
}
