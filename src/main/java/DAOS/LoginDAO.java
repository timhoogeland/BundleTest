package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bundlePWABackend.bundlePWABackend.Login;

public class LoginDAO extends baseDAO{
	
	public List<Login> login(String username, String password) {
		List<Login> results = new ArrayList<Login>();
		String query = "select userid from public." + '"' + "User" + '"' + "where name = ? AND password = ?" + '"';
		try(Connection con = super.getConnection()){
			 
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			String gebruikersnaam = rs.getString("name");
			String wachtwoord = rs.getString("password");
			int id = rs.getInt("userid");
			Login login = new Login(gebruikersnaam, wachtwoord, id);
			results.add(login);
		}
		pstmt.getConnection().close();
		} catch (SQLException sqle) {
		sqle.printStackTrace();
		}

		return results;
		}

	
}
