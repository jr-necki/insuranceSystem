package model.compensation;

import java.util.Date;

public class accidentInfoOut {
	//∞Ì∞¥¿Ã ¿€º∫
	private int accidentID;
	private Date accidentDate;
	private String accidentPlace;
	private String accidentTime;
	private int customerID;
	private String damagedCondition;
	private int insuranceID;

	public accidentInfoOut(){
	}
	
	public int getAccidentID() {
		return accidentID;
	}

	public void setAccidentID(int accidentID) {
		this.accidentID = accidentID;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
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

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDamagedCondition() {
		return damagedCondition;
	}

	public void setDamagedCondition(String damagedCondition) {
		this.damagedCondition = damagedCondition;
	}

	public int getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

}