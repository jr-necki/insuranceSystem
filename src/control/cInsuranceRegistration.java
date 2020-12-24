package control;

import java.sql.SQLException;
import java.util.Date;

import model.customer.customer;
import model.customer.customerList;
import model.customer.customerListImpl;
import model.insurance.insurance;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.insuranceRegistration.insuranceRegistration;
import model.insuranceRegistration.insuranceRegistrationList;
import model.insuranceRegistration.insuranceRegistrationListImpl;
import model.main.insuranceSystemMain;

public class cInsuranceRegistration {
	private customer customer; // model
	private insurance insurance; // model
	private insuranceRegistration insuranceRegistration; // model

	private customerList customerListImpl;
	private insuranceList insuranceListImpl;
	private insuranceRegistrationList insRegistListImpl;
	
	private int custId;
	private int insId;
	
	public cInsuranceRegistration() {
		this.customerListImpl = new customerListImpl();
		this.insuranceListImpl = new insuranceListImpl();
		this.insRegistListImpl = new insuranceRegistrationListImpl();
	}

	public boolean checkCustomerID(int custId) { // 고객 id 확인
		this.custId = custId;
		if (this.customerListImpl.searchByID(custId) != null) {
			this.customer = this.customerListImpl.searchByID(custId);
			return true;
		}
		return false;
	}

	public boolean checkInsuranceID(int insId) { // 보험 id 확인
		this.insId = insId;
		if (this.insuranceListImpl.searchByID(insId) != null) {
			this.insurance = this.insuranceListImpl.searchByID(insId);
			return true;
		}
		return false;
	}

	public void register() { // 보험 가입
		insuranceRegistration = new insuranceRegistration();
		insuranceRegistration.setRegistrationID(insRegistListImpl.getInsuranceRegistrationList().size()+1);
		insuranceRegistration.setCustomerID(this.custId);
		insuranceRegistration.setInsuranceID(this.insId);
		Date d = new Date();
		insuranceRegistration.setRegistrationDate(d);
		insuranceRegistration.register();
		insRegistListImpl.add(insuranceRegistration);
		
		try {
			insuranceSystemMain.insuranceRegistrationDao.insert(insuranceRegistration);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public customer getCustomer() {
		return this.customer;
	}
	
	public insurance getInsurance() {
		return this.insurance;
	}

}
