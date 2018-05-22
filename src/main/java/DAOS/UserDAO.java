package DAOS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.User;

public class UserDAO extends baseDAO {
	
	private String tablename = "public.\"User\"";

    private List<User> selectUsers (String query) {
        List<User> results = new ArrayList<User>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int id = dbResultSet.getInt("userid");
                String userType = dbResultSet.getString("usertype");
                String name = dbResultSet.getString("name");            	
            	int phonenumber = dbResultSet.getInt("phonenumber");
            	String password = dbResultSet.getString("password");
            	String salt = dbResultSet.getString("salt");
            	String status = dbResultSet.getString("status");
            	int adresIDFK = dbResultSet.getInt("adresidfk");
            	int airtimeIDFK = dbResultSet.getInt("airtimeidfk");
           
                User newUser = new User(id, userType, name, phonenumber, password, salt, status, adresIDFK, airtimeIDFK);

                results.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<User> findAll() { return selectUsers("SELECT * From "+tablename); }

    public User findByID(int id) {
        List<User> results = selectUsers("SELECT * FROM "+tablename+" WHERE userid = " + id + "");

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public int findIdByName(String name){
    	List<User> results = selectUsers("SELECT * FROM "+tablename+" WHERE name = '" + name + "'");

        if (results.size() == 0) {
            return (Integer) null;
        } else {
            return results.get(0).getUserID();
        }
    }

    public User update(User User) {
        String query = "UPDATE "+tablename+" SET userid=?, usertype=?, name=?, phonenumber=?,"
        		+ " password=?, salt=?, status=?"
        		+ " WHERE userid=?";

        try (Connection con = super.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, User.getUserID());
            pstmt.setString(2, User.getUserType());
            pstmt.setString(3, User.getName());
            pstmt.setInt(4, User.getPhonenumber());
            pstmt.setString(5, User.getPassword());
            pstmt.setString(6, User.getSalt());
            pstmt.setString(7, User.getStatus());

            int aff = pstmt.executeUpdate(query);
            System.out.println("Row(s) affected: "+aff);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findByID(User.getUserID());
    }

    public boolean delete (User User) {
        boolean result = false;
        boolean UserExists = findByID(User.getUserID()) != null;

        if (UserExists) {
            String query = "DELETE FROM "+tablename+" WHERE userid=?";

            try (Connection con = getConnection()) {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, User.getUserID());

                if (pstmt.executeUpdate() == 1) { // 1 row updated!
                    result = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public User save(User User) {
        String query = "INSERT INTO "+tablename+"(usertype, name, phonenumber, password, salt, status) VALUES (?,?,?,?,?,?) RETURNING UserID";

        try (Connection con = super.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, User.getUserType());
            pstmt.setString(2, User.getName());
            pstmt.setInt(3, User.getPhonenumber());
            pstmt.setString(4, User.getPassword());
            pstmt.setString(5, User.getSalt());
            pstmt.setString(6, User.getStatus());

            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findByID(dbResultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findByID(User.getUserID());
    }
    
    public String findRoleForNameAndPassword(String name, String password){
    	String role = null;
    	String query = "SELECT rol FROM "+tablename+" WHERE name = ? AND password = ?";
    	
    	try(Connection con = super.getConnection()){
    		PreparedStatement pstmt = con.prepareStatement(query);
    		pstmt.setString(1, name);
    		pstmt.setString(2, password);
    		
    		ResultSet rs = pstmt.executeQuery();
    		
    		if(rs.next()){
    			role = rs.getString("rol");
    		}
    	} catch (SQLException sqle){
    		sqle.printStackTrace();
    	}
    	
    	return role;
    }
}
