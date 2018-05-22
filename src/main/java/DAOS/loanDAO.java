package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Loan;

public class loanDAO extends baseDAO {
	
	public List<Loan> selectLoan(){
		List<Loan> resultslist = new ArrayList<Loan>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery("select * from public." + '"' + "loan" + '"');
			
			while (dbResultSet.next()) {
				int loanId = dbResultSet.getInt("loanid");
				int amount = dbResultSet.getInt("amount");
				String status = dbResultSet.getString("status");
				Date startdate = dbResultSet.getDate("startdate");
				int duration = dbResultSet.getInt("duration");
				Date closingdate = dbResultSet.getDate("closingdate");
				String loantype = dbResultSet.getString("loantype");
				int contractId = dbResultSet.getInt("contractidfk");
				
				Loan loan = new Loan(loanId, amount, status, startdate, duration, closingdate, loantype , contractId);
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
