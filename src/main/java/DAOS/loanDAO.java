package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Adress;
import Objects.Loan;
public class loanDAO extends baseDAO {
	
	private String tablename = "public.loan";
	
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
		return selectLoan("select * from "+tablename+" where loanid = " + loanId);
	}
	
    public Loan findById(int id) {
        List<Loan> results = selectLoan("select * from "+tablename+" where loanid = " + id);

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }

	public Loan newLoan(Loan newLoan) {
		String query = 	"INSERT INTO "+tablename+" (loantype, amount, status, startdate, duration, closingdate, paidAmount, contractPdf, description, useridfk) VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING loanid;";
		try (Connection con = super.getConnection()){
		PreparedStatement pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, newLoan.getLoanType());
	        pstmt.setInt(2, newLoan.getAmount());
	        pstmt.setString(3, newLoan.getStatus());
	        pstmt.setDate(4, newLoan.getStartDate());
	        pstmt.setInt(5, newLoan.getDuration());
	        pstmt.setDate(6, newLoan.getClosingDate());
	        pstmt.setInt(7, newLoan.getPaidAmount());
	        pstmt.setString(8, newLoan.getContractPdf());
	        pstmt.setString(9, newLoan.getDescription());
	        pstmt.setInt(10, newLoan.getUserIdFk());


            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findById(dbResultSet.getInt("loanid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findById(newLoan.getLoanId());
    }

	
	public List<Loan> getAllLoans() {
		return selectLoan("select * from "+tablename+";");
	}
	
    public Loan updateLoan(Loan newLoan) {
        String query = "UPDATE "+tablename+" SET loantype=?, status=?, duration=?, closingdate=?, paidamount=?"
        		+ " WHERE loanid=?";

        try (Connection con = super.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newLoan.getLoanType());
	        pstmt.setString(2, newLoan.getStatus());
	        pstmt.setInt(3, newLoan.getDuration());
	        pstmt.setDate(4, newLoan.getClosingDate());
	        pstmt.setInt(5, newLoan.getPaidAmount());
	        pstmt.setInt(6, newLoan.getLoanId());

            int aff = pstmt.executeUpdate();
            System.out.println("Row(s) affected: "+aff);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findById(newLoan.getLoanId());
    }
}
