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
	
	private String tablename = "public.user";

    private List<User> selectUsers (String query) {
        List<User> results = new ArrayList<User>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int userId = dbResultSet.getInt("userid");
                String userType = dbResultSet.getString("usertype");
                String firstName = dbResultSet.getString("firstname");   
                String lastName = dbResultSet.getString("lastname");   
            	int phonenumber = dbResultSet.getInt("phonenumber");
            	String password = dbResultSet.getString("password");
            	String salt = dbResultSet.getString("salt");
            	String status = dbResultSet.getString("status");
            	Date DateOfBirth = dbResultSet.getDate("dateofbirth");
            	int addressIdFk = dbResultSet.getInt("addressidfk");
            	String photo = dbResultSet.getString("photo");
           
                User newUser = new User(userId, userType, firstName, lastName, phonenumber, password, salt, status, addressIdFk, photo, DateOfBirth);


                results.add(newUser);
            }
            stmt.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<User> findAll() { return selectUsers("SELECT * From " + tablename); }

    public User findById(int id) {
        List<User> results = selectUsers("SELECT * FROM " + tablename + " WHERE userid = " + id + "");

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public int findIdByName(String name){
    	List<User> results = selectUsers("SELECT * FROM " + tablename + " WHERE name = '" + name + "'");

        if (results.size() == 0) {
            return (Integer) null;
        } else {
            return results.get(0).getUserId();
        }
    }

    public User update(User User) {
        String query = "UPDATE "+tablename+" SET userid=?, usertype=?, firstname=?, phonenumber=?,"
        		+ " password=?, salt=?, status=?"
        		+ " WHERE userid=?";

        try (Connection con = super.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, User.getUserId());
            pstmt.setString(2, User.getUserType());
            pstmt.setString(3, User.getFirstName());
            pstmt.setInt(4, User.getPhonenumber());
            pstmt.setString(5, User.getPassword());
            pstmt.setString(6, User.getSalt());
            pstmt.setString(7, User.getStatus());

            int aff = pstmt.executeUpdate(query);
            System.out.println("Row(s) affected: "+aff);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findById(User.getUserId());
    }

    public boolean delete (User User) {
        boolean result = false;
        boolean UserExists = findById(User.getUserId()) != null;

        if (UserExists) {
            String query = "DELETE FROM "+tablename+" WHERE userid=?";

            try (Connection con = getConnection()) {
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setInt(1, User.getUserId());

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
        String query = "INSERT INTO "+tablename+"(userid, usertype, firstname, lastname, phonenumber, password, salt, status, dateofbirth, photo, addressidfk) VALUES (?,?,?,?,?,?,?,?,?,?,?) RETURNING userid";
        try (Connection con = super.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, User.getUserId());
            pstmt.setString(2, User.getUserType());
            pstmt.setString(3, User.getFirstName());
            pstmt.setString(4, User.getLastName());
            pstmt.setInt(5, User.getPhonenumber());
            pstmt.setString(6, User.getPassword());
            pstmt.setString(7, User.getSalt());
            pstmt.setString(8, User.getStatus());
            pstmt.setDate(9, User.getDateOfBirth());
            pstmt.setString(10, User.getPhoto());
            pstmt.setInt(11, User.getAddressIdFk());
            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findById(dbResultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findById(User.getUserId());
    }
    
    public String findRoleForNameAndPassword(String name, String password){
    	String role = null;    	
    	String query = "SELECT usertype FROM "+tablename+" WHERE username = ? AND password = ?";
    	System.out.println(query);
    	
    	try(Connection con = super.getConnection()){
    		PreparedStatement pstmt = con.prepareStatement(query);
    		pstmt.setString(1, name);
    		pstmt.setString(2, password);
    		
    		ResultSet rs = pstmt.executeQuery();
    		
    		if(rs.next()){
    			role = rs.getString("usertype");
    			System.out.println(role);
    		}
    	} catch (SQLException sqle){
    		sqle.printStackTrace();
    	}
    	
    	return role;
    }
}
