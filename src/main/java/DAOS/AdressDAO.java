package DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Objects.Adress;
import Objects.Contract;

public class AdressDAO extends baseDAO {

	private String tablename = "public.\"adress\"";

    private List<Adress> selectAdresss (String query) {
        List<Adress> results = new ArrayList<Adress>();

        try (Connection con = super.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int id = dbResultSet.getInt("adressid");
                String street = dbResultSet.getString("street");
                int number = dbResultSet.getInt("number");            	
            	String country = dbResultSet.getString("country");
            	String postalcode = dbResultSet.getString("postalCode");
           
                Adress newAdress = new Adress(id, street, number, country, postalcode);

                results.add(newAdress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Adress> findAll() { return selectAdresss("SELECT * From "+tablename); }

    public Adress findByID(int id) {
        List<Adress> results = selectAdresss("SELECT * FROM "+tablename+" WHERE adressid = " + id + "");

        if (results.size() == 0) {
            return null;
        } else {
            return results.get(0);
        }
    }
    
    public List<Adress> findAdressesByUserIDFK(int id) {
        List<Adress> results = selectAdresss("SELECT * FROM "+tablename+" WHERE useridfk = '" + id + "'");
        return results;
    }
    
    public Adress save(Adress adress) {
        String query = "INSERT INTO "+tablename+" (street, number, country, postalcode) VALUES (?,?,?,?,?) RETURNING adressid";

        try (Connection con = super.getConnection()){
            PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, adress.getStreet());
            pstmt.setInt(2, adress.getNumber());
            pstmt.setString(3, adress.getCountry());
            pstmt.setString(4, adress.getPostalCode());

            ResultSet dbResultSet = pstmt.executeQuery();
            if(dbResultSet.next()) {
                return findByID(dbResultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return findByID(adress.getAdressID());
    }
}
