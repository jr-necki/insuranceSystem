package model.customer;

public class customer {
	public enum job {DRIVER, INTERNALEMPLOYEE, EXTERNALEMPLOYEE, SOLDIER, NO_JOB}
	public enum illHistory {NOTHING, CANCER, BLOODPRESURE, GLYCOSURIA, ACCIDENT}
	public enum familyIllHistory {NOTHING, CANCER, BLOODPRESURE, GLYCOSURIA}

	private int customerID;
	private String customerName;
	private boolean gender; // true : female, false : male
	private String accidentHistory;
	private String address;	
	private String contactNumber;
	private String identificationNumber;
	private property property=new property();
	private job job;
	private int age;
	private illHistory illHistory;
	private familyIllHistory familyIllHistory;
	private int propertyID;

	public customer(){

	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAccidentHistory() {
		return accidentHistory;
	}

	public void setAccidentHistory(String accidentHistory) {
		this.accidentHistory = accidentHistory;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public property getProperty() {
		return property;
	}

	public void setProperty(property property) {
		this.property = property;
	}

	public job getJob() {
		return job;
	}

	public void setJob(job job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public illHistory getIllHistory() {
		return illHistory;
	}

	public void setIllHistory(illHistory illHistory) {
		this.illHistory = illHistory;
	}

	public familyIllHistory getFamilyIllHistory() {
		return familyIllHistory;
	}

	public void setFamilyIllHistory(familyIllHistory familyIllHistory) {
		this.familyIllHistory = familyIllHistory;
	}

	public void setPropertyID(int id) {
		this.propertyID = id;
	}

	public int getPropertyID() {
		return propertyID;
	}
	
}