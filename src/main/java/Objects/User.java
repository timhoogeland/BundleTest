package Objects;

import java.sql.Date;

public class User {
	private int userID;
	
	private String userType;
	
	private String firstName;
	
	private String lastName;
	
	private int phonenumber;
	
	private String password;
	
	private String salt;
	
	private String status;
	
	private int addressIdFk;
	
	private String photo;
	
	public User(int userID, String userType, String firstName, String lastName, int phonenumber, String password, String salt, String status,
			int adresIDFK, String photo) {
		this.userID = userID;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.password = password;
		this.salt = salt;
		this.setStatus(status);
		this.addressIdFk = adresIDFK;
		this.setPhoto(photo);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirsName(String firstName) {
		this.firstName = firstName;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (salt != null){
			this.password = password;
		}else{
			salt = "";
		}
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		if (salt != null){
			this.salt = salt;
		}else{
			this.salt = "";
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status != null){
			this.status = status;
		}else{
			this.status = "";
		}
	}

	public int getAddressIdFk() {
		return addressIdFk;
	}

	public void setAddressIdFk(int addressIdFk) {
		this.addressIdFk = addressIdFk;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		if (photo != null){
			this.photo = photo;
		}else{
			this.photo = "";
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
