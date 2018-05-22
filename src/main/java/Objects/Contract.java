package Objects;

public class Contract {
	private int contractID;
	
	private String status;
	
	private String description;
	
	private String contractPDF;
	
	private int userIDFK;

	public Contract(int contractID, String status, String description, String contractPDF, int userIDFK) {
		this.contractID = contractID;
		this.status = status;
		this.description = description;
		this.contractPDF = contractPDF;
		this.userIDFK = userIDFK;
	}

	public int getContractID() {
		return contractID;
	}

	public void setContractID(int contractID) {
		this.contractID = contractID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContractPDF() {
		return contractPDF;
	}

	public void setContractPDF(String contractPDF) {
		this.contractPDF = contractPDF;
	}

	public int getUserIDFK() {
		return userIDFK;
	}

	public void setUserIDFK(int userIDFK) {
		this.userIDFK = userIDFK;
	}
	
}
