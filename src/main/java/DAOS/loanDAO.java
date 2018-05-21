package DAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bundlePWABackend.bundlePWABackend.Loan;

public class loanDAO extends baseDAO {
	List<Loan> resultslist = new ArrayList<Loan>();
	public List<Loan> selectLoan(){
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery("select * from public." + '"' + "loan" + '"');
			
			while (dbResultSet.next()) {
				int loanId = dbResultSet.getInt("loanid");
				int amount = dbResultSet.getInt("amount");
				String status = dbResultSet.getString("status");
				String startdate = dbResultSet.getString("startdate");
				int duration = dbResultSet.getInt("duration");
				String closingdate = dbResultSet.getString("closingdate");
				String loantype = dbResultSet.getString("loantype");
				int contractId = dbResultSet.getInt("contractidfk");
				Loan loan = new Loan(loanId,amount,status,startdate,duration,closingdate,loantype,contractId);
				resultslist.add(loan);
			}
			stmt.getConnection().close();
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return resultslist;
	}
}
