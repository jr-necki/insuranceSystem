package model.insuranceRegistration;

import java.sql.SQLException;
import java.util.ArrayList;

import model.main.insuranceSystemMain;

public class insuranceRegistrationListImpl implements insuranceRegistrationList {
	private ArrayList<insuranceRegistration> insuranceRegistrationList;
	public insuranceRegistration insuranceRegistration;
	
	public insuranceRegistrationListImpl() {
		try {
			this.insuranceRegistrationList = insuranceSystemMain.insuranceRegistrationDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean add(insuranceRegistration insuranceRegistration) {
		this.insuranceRegistrationList.add(insuranceRegistration);
		return true;
	}

	public boolean delete(insuranceRegistration insuranceRegistration) {
		this.insuranceRegistrationList.remove(insuranceRegistration);
		return true;
	}

	public boolean deleteByID(int customerID) {
		return true;
	}

	public insuranceRegistration searchByID(int customerID) {
		return null;
	}
	
	public ArrayList<insuranceRegistration> getInsuranceRegistrationList() {
		return this.insuranceRegistrationList;
	}
}