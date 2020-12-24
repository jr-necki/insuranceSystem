package model.insuranceRegistration;

import java.util.Date;
import java.util.HashMap;

import model.customer.customer;

public class insuranceRegistration {

	private int registrationID;
	private int customerID;
	private int insuranceID;
	private Date registrationDate;
	
	customer customer=new customer();

	private HashMap<Integer, Integer> registrationMap = new HashMap<Integer, Integer>(); // key, value 같이 들어감

	public insuranceRegistration() {

	}

	public void register() {
		registrationMap.put(this.customerID,this.insuranceID);
	}

	public int getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(int registrationID) {
		this.registrationID=registrationID;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date date) {
		this.registrationDate = date;
	}

}