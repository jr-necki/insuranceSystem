package model.compensation;

public class accidentInfo {
	private int accidentID;
	private int customerID;
	private int insuranceID;
	private String damagedCondition;
	private String accidentType;
	private int accidentDate;
	private String accidentPlace;
	private String accidentTime;
	private String customerName;
	private String identificationNumber;
	
	public accidentInfo() {}

	public int getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(int accidentID) {
		this.accidentID = accidentID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public String getDamagedCondition() {
		return damagedCondition;
	}

	public void setDamagedCondition(String damagedCondition) {
		this.damagedCondition = damagedCondition;
	}

	public int getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(int accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getAccidentPlace() {
		return accidentPlace;
	}

	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

}
