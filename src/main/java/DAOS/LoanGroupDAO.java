package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Group;
import Objects.LoanGroup;

public class LoanGroupDAO extends baseDAO{
	public List<LoanGroup> selectGroup(String query){
		List<LoanGroup> resultslist = new ArrayList<LoanGroup>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int groupId = dbResultSet.getInt("id");
				int loanofficerfk = dbResultSet.getInt("loanofficerfk");
				LoanGroup group= new LoanGroup(groupId, loanofficerfk);
				resultslist.add(group);
			}
			stmt.getConnection().close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return resultslist;
	}
	
	public List<LoanGroup> getAllGroups(int loanofficerId){
		return selectGroup("select * FROM public." + '"' + "Group" + '"'+ "g where g.loanofficerfk ="+ loanofficerId + ";");
	}
}
