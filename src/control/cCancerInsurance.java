package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.insurance.cancerInsurance;
import model.insurance.contractCondition;
import model.insurance.insurance;
import model.insurance.insurance.insuranceType;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.main.insuranceSystemMain;

public class cCancerInsurance {
	public insurance cancerInsurance; // model
	private contractCondition cancerInsuranceCondition; // model

	private insuranceList insuranceListImpl;

	public cCancerInsurance() {
		this.insuranceListImpl = new insuranceListImpl();
	}

	public String getID() {
		String id = Integer.toString(insuranceListImpl.getInsuranceList().size()+1);
		return id;
	}

	public void makeInsurance(int insuranceID, String insuranceName, insuranceType cancerinsurance2, String description, 
			int contractConditionID, String date, int guaranteeAmount, int paymentAmount, int paymentDay) {
		this.cancerInsurance = new cancerInsurance();
		this.cancerInsuranceCondition = new contractCondition();
		Date expirationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			expirationDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cancerInsurance.setInsuranceID(insuranceID);
		this.cancerInsurance.setInsuranceName(insuranceName);
		this.cancerInsurance.setInsuranceType(insuranceType.CANCERINSURANCE);
		this.cancerInsurance.setDescription(description);
		
		this.cancerInsuranceCondition.setContractConditionID(contractConditionID);
		this.cancerInsuranceCondition.setExpirationDate(expirationDate);
		this.cancerInsuranceCondition.setGuaranteeAmount(guaranteeAmount);
		this.cancerInsuranceCondition.setPaymentAmount(paymentAmount);
		this.cancerInsuranceCondition.setPaymentDay(paymentDay);
		this.cancerInsurance.setContractCondition(this.cancerInsuranceCondition);
		this.insuranceListImpl.add(this.cancerInsurance); // insuranceList¿¡ Ãß°¡
		
		try {
			insuranceSystemMain.insuranceDao.insert(cancerInsurance); // db insert
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
