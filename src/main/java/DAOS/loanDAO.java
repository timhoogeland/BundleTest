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
				String loanType = dbResultSet.getString("loantype");
				int amount = dbResultSet.getInt("amount");
				String status = dbResultSet.getString("status");
				Date startDate = dbResultSet.getDate("startdate");
				int duration = dbResultSet.getInt("duration");
				Date closingDate = dbResultSet.getDate("closingdate");
				int paidAmount = dbResultSet.getInt("paidamount");
				String contractPdf = dbResultSet.getString("contractpdf");
				String description = dbResultSet.getString("description");
				int userIdFk = dbResultSet.getInt("useridfk");
				
				Loan loan = new Loan(loanId, loanType, amount, status, startDate, duration, closingDate, paidAmount, contractPdf, description, userIdFk);
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
		String query = 	"INSERT INTO public.loan(" +
						"loanid, loantype, amount, status, startdate, duration, closingdate, paidAmount, contractPdf, description, useridfk) " + 
						"VALUES(" +
						newLoan.getLoanId() + ", '" +
						newLoan.getLoanType() + "', " +
						newLoan.getAmount() + ", '" + 
						newLoan.getStatus() + "', " +
						"to_date('" + newLoan.getStartDate().toString() + "', 'YYYY-MM-DD'), " +
						newLoan.getDuration() + ", " +
						"to_date('" + newLoan.getClosingDate().toString() + "', 'YYYY-MM-DD'), " + 
						newLoan.getPaidAmount() + ", '" + 
						newLoan.getContractPdf() + "', '" +
						newLoan.getDescription()  + "', " +
						newLoan.getUserIdFk() + ");";

		try(Connection con = super.getConnection()){
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
		return selectLoan("select * from public.loan;");
	}
	
	public boolean updateLoan(Loan loan){
		boolean result = false;
		String query = "UPDATE public.loan SET " +
						"status = '" + loan.getStatus() + "', " +
						"duration = " + loan.getDuration() + ", " +
						"closingdate = to_date('" + loan.getClosingDate().toString() + "', 'YYYY-MM-DD'), " + 
						"paidamount = " + loan.getPaidAmount() + ", " + 
						"contractpdf = '" + loan.getContractPdf() + "', " +
						"description = '" + loan.getDescription()  + "' " + 
						"WHERE loanid = " + loan.getLoanId() + ";";
		
		try(Connection con = super.getConnection()){
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
}
