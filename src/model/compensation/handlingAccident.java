package model.compensation;

public class handlingAccident {
	
	private int handlingID;
	private int accidentID;
	private int customerID;
	private int insuranceID;
	private int amount;
	
	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

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

	public int getHandlingID() {
		return handlingID;
	}

	public void setHandlingID(int handlingID) {
		this.handlingID = handlingID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}