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
	
	public List<Loan> selectLoan(String query){
		List<Loan> resultslist = new ArrayList<Loan>();
		try(Connection con = super.getConnection()){
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);
			
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
	public List<Loan> getLoanById(int loanId){
		return selectLoan("select * from public." + '"' + "loan" + '"' + "where loanid = " + loanId);
	}

	public boolean newLoan(Loan newLoan) {
		boolean result = false;
		String query = 	"INSERT INTO public.loan(loanid" + 
						"amount, status, startdate, duration, closingdate, loantype, contractidfk) " + 
						"VALUES (" +
						newLoan.getLoanId() + ", " +
						newLoan.getAmount() + ", " + 
						newLoan.getStatus() + ", " +
						newLoan.getStartDate() + ", " +
						newLoan.getDuration() + ", " +
						newLoan.getClosingDate() + ", " +
						newLoan.getLoanType() + ", " +
						newLoan.getContractId() + ", " +				
						");";
		try{
			Connection con = super.getConnection();
			Statement stmt = con.createStatement();
			if (stmt.executeUpdate(query) == 1){
				result = true;
				stmt.getConnection().close();
			}
		}catch (SQLException e){
			e.printStackTrace();					
		}
		return result;
	}
	public List<Loan> getAllLoans() {
		return selectLoan("select * from public." + '"' + "loan" + '"' );
	}
}
