import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class tempGeneratePasswordAndSalt {

  public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
	  String[] result = generateStrongPasswordHash("12345");
	  System.out.println("password: " + result[0]);
	  System.out.println("salt: " + result[1]);
  }
  
  private static String getSalt() throws NoSuchAlgorithmException {
	  final Random r = new SecureRandom();
	  byte[] salt = new byte[32];
	  r.nextBytes(salt);
	  return DatatypeConverter.printHexBinary(salt);
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

 private static String[] generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
    int iterations = 985;
    char[] chars = password.toCharArray();
    byte[] salt = hexStringToByteArray(getSalt());
     
    PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    byte[] hash = skf.generateSecret(spec).getEncoded();
    return new String[] { toHex(hash), toHex(salt) };
}
}