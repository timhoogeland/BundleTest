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
	public List<LoanGroup> selectLoanGroup(String query){
		List<LoanGroup> resultslist = new ArrayList<LoanGroup>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			while (dbResultSet.next()) {
				int groupId = dbResultSet.getInt("groupidfk");
				int loanId = dbResultSet.getInt("loanidfk");
				LoanGroup loanGroup= new LoanGroup(groupId, loanId);
				resultslist.add(loanGroup);
			}
			stmt.getConnection().close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return resultslist;
	}
	
	public List<LoanGroup> getAllLoanGroups() {
		return selectLoanGroup("select * FROM public.grouploan;");
	}
	
	public List<LoanGroup> getAllLoanGroupsByLoanOfficer(int loanofficerId){
		return selectLoanGroup("select l.groupidfk, l.loanidfk FROM public.grouploan l, public.group g where l.groupidfk = g.id and g.loanofficeridfk =" + loanofficerId + ";");
		
	}

	public List<LoanGroup> getLoanGroupById(int groupId) {
		return selectLoanGroup("Select * FROM public.grouploan where groupidfk = " + groupId);
	}

}
