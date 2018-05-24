package Services;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import DAOS.LoginDAO;
import Objects.Login;

public class LoginService {
LoginDAO login = new LoginDAO();
	public int getUserID(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return login.login(username, password);
	}
}
