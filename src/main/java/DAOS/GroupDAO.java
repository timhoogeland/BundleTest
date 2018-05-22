package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Group;

public class GroupDAO extends baseDAO{
	
	public List<Group> getGroup(String query){
		List<Group> resultslist = new ArrayList<Group>();
		
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int userId = dbResultSet.getInt("userid");
				int loanId = dbResultSet.getInt("loanid");
				Group group= new Group(userId, loanId);
				resultslist.add(group);
			}
			stmt.getConnection().close();
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
		return resultslist;
	}
	
	public List<Group> getGroupById(int groupId){
		return getGroup("select u.userid, l.loanid " + 
						"from public." + '"' + "loan" + '"' + " l, " + 
						"public." + '"' + "contract" + '"' + " c, " +
						"public."  + '"' + "User" + '"' + " u, " + 
						"public."  + '"' + "grouploan" + '"' + " g " + 
						"where g.loanidfk = l.loanid " +
						"and l.contractidfk = c.contractid " + 
						"and c.useridfk = u.userid " + 
						"and g.groupidfk = " + groupId + ";");
	}
}
