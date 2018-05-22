package Objects;

import java.sql.Date;

public class User {
	private int userID;
	
	private String userType;
	
	private String name;
	
	private int phonenumber;
	
	private String password;
	
	private String salt;
	
	private String status;
	
	private Date dateOfBirth;

	private int adresIDFK;
	
	private int airtimeIDFK;
	
	public User(int userID, String userType, String name, int phonenumber, String password, String salt, String status, Date dateofbirth,
			int adresIDFK, int airtimeIDFK) {
		this.userID = userID;
		this.userType = userType;
		this.name = name;
		this.phonenumber = phonenumber;
		this.password = password;
		this.salt = salt;
		this.status = status;
		this.dateOfBirth = dateofbirth;
		this.adresIDFK = adresIDFK;
		this.airtimeIDFK = airtimeIDFK;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAdresIDFK() {
		return adresIDFK;
	}

	public void setAdresIDFK(int adresIDFK) {
		this.adresIDFK = adresIDFK;
	}

	public int getAirtimeIDFK() {
		return airtimeIDFK;
	}

	public void setAirtimeIDFK(int airtimeIDFK) {
		this.airtimeIDFK = airtimeIDFK;
	}
}
