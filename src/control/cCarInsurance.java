package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.insurance.carInsurance;
import model.insurance.carInsurance.carType;
import model.insurance.contractCondition;
import model.insurance.insurance;
import model.insurance.insurance.insuranceType;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.main.insuranceSystemMain;

public class cCarInsurance {
	public insurance carInsurance; // model
	private contractCondition carInsuranceCondition; // model

	private insuranceList insuranceListImpl;

	public cCarInsurance() {
		this.insuranceListImpl = new insuranceListImpl();
	}
	
	public String getID() {
		String id = Integer.toString(insuranceListImpl.getInsuranceList().size()+1);
		return id;
	}
	
	public void makeInsurance(int insuranceID, String insuranceName, insuranceType carinsurance2, String description,
			boolean accident, int drivingExperience, String cType, String carNumber, int contractConditionID,
			String date, int guaranteeAmount, int paymentAmount, int paymentDay) {
		this.carInsurance = new carInsurance();
		this.carInsuranceCondition = new contractCondition();
		Date expirationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			expirationDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.carInsurance.setInsuranceID(insuranceID);
		this.carInsurance.setInsuranceName(insuranceName);
		this.carInsurance.setInsuranceType(insuranceType.CARINSURANCE);
		this.carInsurance.setDescription(description);
		((carInsurance)this.carInsurance).setAccidentHistory(accident);
		((carInsurance)this.carInsurance).setDrivingExperience(drivingExperience);
		((carInsurance)this.carInsurance).setCarType(carType.valueOf(cType));
		((carInsurance)this.carInsurance).setCarRegistrationNumber(carNumber);
		
		this.carInsuranceCondition.setContractConditionID(contractConditionID);
		this.carInsuranceCondition.setExpirationDate(expirationDate);
		this.carInsuranceCondition.setGuaranteeAmount(guaranteeAmount);
		this.carInsuranceCondition.setPaymentAmount(paymentAmount);
		this.carInsuranceCondition.setPaymentDay(paymentDay);
		this.carInsurance.setContractCondition(this.carInsuranceCondition);
		this.insuranceListImpl.add(this.carInsurance);
		
		try {
			insuranceSystemMain.insuranceDao.insert(carInsurance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
