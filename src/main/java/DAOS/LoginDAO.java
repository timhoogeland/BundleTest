package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bundlePWABackend.bundlePWABackend.Login;

public class LoginDAO extends baseDAO{
	
	public int login(String username, String password) {
		int id = 0;
		String query = "select userid from public." + '"' + "User" + '"' + " where name =" +"'"+ username + "'"+ " AND password = " +"'"+ password +"'" ;
		try(Connection con = super.getConnection()){
			 
		PreparedStatement pstmt = con.prepareStatement(query);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			id = rs.getInt("userid");
		}
		pstmt.getConnection().close();
		} catch (SQLException sqle) {
		sqle.printStackTrace();
		}

		return id;
		}

	
}
