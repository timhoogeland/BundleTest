package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class loanDAO extends baseDAO {
	private String results = "";
	public String selectLoan(String query){
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
			while (dbResultSet.next()) {
				results = results + dbResultSet.getInt("id");
				results = results + dbResultSet.getInt("loanofficerfk");
			}
			stmt.getConnection().close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return "result = " + results;
	}
}
