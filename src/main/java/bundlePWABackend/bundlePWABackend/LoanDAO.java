package bundlePWABackend.bundlePWABackend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO extends BaseDAO{
	
		public List<Loan> findAll(){
			List<Loan> results = new ArrayList<Loan>();
			try(Connection con = super.getConnection()){
				Statement stmt = con.createStatement();
				ResultSet dbResultSet = stmt.executeQuery("Select * from loan");
				while (dbResultSet.next()) {
			        String code = dbResultSet.getString("code");
			        String code2 = dbResultSet.getString("code2");
			        Loan newCountry = new Loan(code, code2);
			        results.add(newCountry);
			      }
		
			}catch (SQLException sqle){
				sqle.printStackTrace();
			}
			return results;
		}
}
