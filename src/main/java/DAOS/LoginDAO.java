package DAOS;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

import Objects.Login;

public class LoginDAO extends baseDAO {
	public int login(String username, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int userid = 0;
		int database_userid = 0;
		String database_password = null;
		String database_salt = null;

		String query = "select userid, password, salt from public.user where username = ?";
		
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				database_userid = rs.getInt("userid");
				database_password = rs.getString("password");
				database_salt = rs.getString("salt");
			}
			
			pstmt.getConnection().close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		if (database_password != null && database_salt != null && database_userid != 0) {
			int iterations = 985;
			char[] chars = password.toCharArray();
			byte[] salt = hexStringToByteArray(database_salt);
			
			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        byte[] hash = skf.generateSecret(spec).getEncoded();
	        String client_password = toHex(hash);

	        if(client_password.equals(database_password)) {
	        	userid = database_userid;
	        }
		}

		return userid;
	}
	
	private static String toHex(byte[] bytes) {
		  String hex = DatatypeConverter.printHexBinary(bytes);
		  return new String(hex);
	}
	
	private static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

}