package Objects;

public class Adress {

	private int adressID;
	
	private String street;
	
	private int number;

	private String country;
	
	private String postalCode;
	
	public Adress(int adressID, String street, int number, String country, String postalCode) {
		this.adressID = adressID;
		this.street = street;
		this.number = number;
		this.country = country;
		this.postalCode = postalCode;
	}
	
	
	public int getAdressID() {
		return adressID;
	}

	public void setAdressID(int adressID) {
		this.adressID = adressID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
