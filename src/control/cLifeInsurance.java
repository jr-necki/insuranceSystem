package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.insurance.contractCondition;
import model.insurance.insurance;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.insurance.insurance.insuranceType;
import model.insurance.lifeInsurance;
import model.main.insuranceSystemMain;

public class cLifeInsurance {
	public insurance lifeInsurance; // model
	public contractCondition lifeInsuranceCondition; // model

	private insuranceList insuranceListImpl;
	
	public  cLifeInsurance() {
		this.insuranceListImpl = new insuranceListImpl();
	}
	
	public String getID() {
		String id = Integer.toString(insuranceListImpl.getInsuranceList().size()+1);
		return id;
	}
	
	public void makeInsurance(int insuranceID, String insuranceName, insuranceType lifeinsurance, String description,
			int contractConditionID, String date, int guaranteeAmount, int paymentAmount, int paymentDay) {	
		this.lifeInsurance = new lifeInsurance();
		this.lifeInsuranceCondition = new contractCondition();
		Date expirationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			expirationDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.lifeInsurance.setInsuranceID(insuranceID);
		this.lifeInsurance.setInsuranceName(insuranceName);
		this.lifeInsurance.setInsuranceType(insuranceType.LIFEINSURANCE);
		this.lifeInsurance.setDescription(description);
		
		this.lifeInsuranceCondition.setContractConditionID(contractConditionID);
		this.lifeInsuranceCondition.setExpirationDate(expirationDate);
		this.lifeInsuranceCondition.setGuaranteeAmount(guaranteeAmount);
		this.lifeInsuranceCondition.setPaymentAmount(paymentAmount);
		this.lifeInsuranceCondition.setPaymentDay(paymentDay);
		this.lifeInsurance.setContractCondition(this.lifeInsuranceCondition);
		this.insuranceListImpl.add(this.lifeInsurance); // insuranceList¿¡ Ãß°¡

		try {
			insuranceSystemMain.insuranceDao.insert(lifeInsurance);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<insurance> getInsuanceList() {
		return insuranceListImpl.getInsuranceList();
	}
	
}
