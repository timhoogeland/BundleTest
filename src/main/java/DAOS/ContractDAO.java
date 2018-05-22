package DAOS;

import java.util.List;

import Objects.Contract;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.User;

public class ContractDAO extends baseDAO {
	
	private String tablename = "public.\"contract\"";

    private List<Contract> selectContracts (String query) {
        List<Contract> results = new ArrayList<Contract>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int id = dbResultSet.getInt("contractid");
                String status = dbResultSet.getString("status");
                String desc = dbResultSet.getString("description");            	
            	String pdf = dbResultSet.getString("contractpdf");
            	int useridfk = dbResultSet.getInt("useridfk");
           
                Contract newContract = new Contract(id, status, desc, pdf, useridfk);

                results.add(newContract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Contract> findAll() { return selectContracts("SELECT * From "+tablename); }

    public Contract findByID(int id) {
        List<Contract> results = selectContracts("SELECT * FROM "+tablename+" WHERE contractid = " + id + "");

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public List<Contract> findContractsByUserIDFK(int id) {
        List<Contract> results = selectContracts("SELECT * FROM "+tablename+" WHERE useridfk = '" + id + "'");
        return results;
    }
    
//    public int findIdByName(String name){
//    	List<User> results = selectContracts("SELECT * FROM "+tablename+" WHERE name = '" + name + "'");
//
//        if (results.size() == 0) {
//            return (Integer) null;
//        } else {
//            return results.get(0).getUserID();
//        }
//    }
//
//    public User update(User User) {
//        String query = "UPDATE "+tablename+" SET userid=?, usertype=?, name=?, phonenumber=?,"
//        		+ " password=?, salt=?, status=?"
//        		+ " WHERE userid=?";
//
//        try (Connection con = super.getConnection()) {
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setInt(1, User.getUserID());
//            pstmt.setString(2, User.getUserType());
//            pstmt.setString(3, User.getName());
//            pstmt.setInt(4, User.getPhonenumber());
//            pstmt.setString(5, User.getPassword());
//            pstmt.setString(6, User.getSalt());
//            pstmt.setString(7, User.getStatus());
//
//            int aff = pstmt.executeUpdate(query);
//            System.out.println("Row(s) affected: "+aff);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return findByID(User.getUserID());
//    }
//
//    public boolean delete (User User) {
//        boolean result = false;
//        boolean UserExists = findByID(User.getUserID()) != null;
//
//        if (UserExists) {
//            String query = "DELETE FROM "+tablename+" WHERE userid=?";
//
//            try (Connection con = getConnection()) {
//                PreparedStatement pstmt = con.prepareStatement(query);
//                pstmt.setInt(1, User.getUserID());
//
//                if (pstmt.executeUpdate() == 1) { // 1 row updated!
//                    result = true;
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return result;
//    }
//
    public Contract save(Contract contract) {
        String query = "INSERT INTO "+tablename+" (status, description, contractpdf, useridfk) VALUES (?,?,?,?) RETURNING contractid";

        try (Connection con = super.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, contract.getStatus());
            pstmt.setString(2, contract.getDescription());
            pstmt.setString(3, contract.getContractPDF());
            pstmt.setInt(4, contract.getUserIDFK());

            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findByID(dbResultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findByID(contract.getContractID());
    }

//    public String findRoleForNameAndPassword(String name, String password){
//    	String role = null;
//    	String query = "SELECT rol FROM "+tablename+" WHERE name = ? AND password = ?";
//    	
//    	try(Connection con = super.getConnection()){
//    		PreparedStatement pstmt = con.prepareStatement(query);
//    		pstmt.setString(1, name);
//    		pstmt.setString(2, password);
//    		
//    		ResultSet rs = pstmt.executeQuery();
//    		
//    		if(rs.next()){
//    			role = rs.getString("rol");
//    		}
//    	} catch (SQLException sqle){
//    		sqle.printStackTrace();
//    	}
//    	
//    	return role;
//    }
//}


}
