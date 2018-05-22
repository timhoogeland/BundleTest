package Services;
import java.util.List;

import DAOS.LoginDAO;
import Objects.Login;

public class LoginService {
LoginDAO login = new LoginDAO();
	public int getUserID(String username, String password) {
		return login.login(username, password);
	}
}
