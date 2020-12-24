package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.customer.customer;
import model.customer.customerList;
import model.customer.customerListImpl;
import model.customer.customer.familyIllHistory;
import model.customer.customer.illHistory;
import model.customer.customer.job;
import model.customer.property;
import model.main.insuranceSystemMain;

public class cCustomer {
	private customer customer; // model
	private property property; // model

	private customerList customerListImpl;
	
	public cCustomer() {
		this.customerListImpl = new customerListImpl();
	}
	
	public ArrayList<customer> getCustomerList() {
		return customerListImpl.getCustomerList();
	}

	public void addCustomer(String name, String gender, String address, String identificationNO, String phoneNo,
			String house, String car, String age, String txtJob, String txtIllHistory, String txtFamilyIll,
			String txtAccident) {		
		this.customer = new customer();
		this.property = new property();
		
		customer.setCustomerID(customerListImpl.getCustomerList().size() + 1);
		customer.setCustomerName(name);
		if (gender.equals("¿©ÀÚ")) {
			customer.setGender(true);
		} else {
			customer.setGender(false);
		}
		int num = Integer.parseInt(age);
		customer.setAge(num);
		customer.setAddress(address);
		customer.setContactNumber(phoneNo);
		customer.setIdentificationNumber(identificationNO);

		customer.setProperty(property);
		customer.setJob(job.valueOf(txtJob));
		customer.setIllHistory(illHistory.valueOf(txtIllHistory));
		customer.setFamilyIllHistory(familyIllHistory.valueOf(txtFamilyIll));
		customer.setAccidentHistory(txtAccident);

		int numInt = Integer.parseInt(house);
		property.setHouse(numInt);
		int numInt2 = Integer.parseInt(car);
		property.setCar(numInt2);
		property.setID(customerListImpl.getCustomerList().size() + 1);

		try {
			insuranceSystemMain.propertyDao.insert(property);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer.setPropertyID(property.getID());
		customerListImpl.add(customer);

		try {
			insuranceSystemMain.customerDao.insert(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
