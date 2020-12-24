package model.insuranceRegistration;

import java.util.ArrayList;

public interface insuranceRegistrationList {

	public boolean add(insuranceRegistration insuranceRegistration);
	public boolean delete(insuranceRegistration insuranceRegistration);
	public boolean deleteByID(int registrationID);
	public insuranceRegistration searchByID(int registrationID);
	public ArrayList<insuranceRegistration> getInsuranceRegistrationList();
	
}