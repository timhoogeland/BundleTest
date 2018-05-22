package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Group;

public class GroupDAO extends baseDAO{
	public List<Group> selectGroup(int id){
		List<Group> resultslist = new ArrayList<Group>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery("select * FROM public." + '"' + "Group" + '"'+ "g where g.loanofficerfk ="+ id + ";");
			while (dbResultSet.next()) {
				int groupId = dbResultSet.getInt("id");
				int loanofficerfk = dbResultSet.getInt("loanofficerfk");
				Group group= new Group(groupId, loanofficerfk);
				resultslist.add(group);
			}
			stmt.getConnection().close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return resultslist;
	}
}
