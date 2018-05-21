package Services;

public class LoginServiceProvider {
	private static LoginService loginService= new LoginService();

	public static LoginService getUserId() {
		return loginService;
	}
}
