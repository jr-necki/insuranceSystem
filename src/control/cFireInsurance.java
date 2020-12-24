package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.insurance.contractCondition;
import model.insurance.fireInsurance;
import model.insurance.insurance;
import model.insurance.insurance.insuranceType;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.main.insuranceSystemMain;

public class cFireInsurance {
	public insurance fireInsurance; // model
	private contractCondition fireInsuranceCondition; // model

	private insuranceList insuranceListImpl;
	
	public cFireInsurance() {
		this.insuranceListImpl = new insuranceListImpl();
	}

	public String getID() {
		String id = Integer.toString(insuranceListImpl.getInsuranceList().size()+1);
		return id;
	}

	public void makeInsurance(int insuranceID, String insuranceName, insuranceType fireinsurance2, String description,
			int buildingGrade, int buildingSurfaceArea, int contractConditionID, String date, int guaranteeAmount,
			int paymentAmount, int paymentDay) {
		this.fireInsurance = new fireInsurance();
		this.fireInsuranceCondition = new contractCondition();
		Date expirationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			expirationDate = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fireInsurance.setInsuranceID(insuranceID);
		this.fireInsurance.setInsuranceName(insuranceName);
		this.fireInsurance.setInsuranceType(insuranceType.FIREINSURANCE);
		this.fireInsurance.setDescription(description);
		((fireInsurance)this.fireInsurance).setBuildingGrade(buildingGrade);
		((fireInsurance)this.fireInsurance).setBuildingSurfaceArea(buildingSurfaceArea);
	
		this.fireInsuranceCondition.setContractConditionID(contractConditionID);
		this.fireInsuranceCondition.setExpirationDate(expirationDate);
		this.fireInsuranceCondition.setGuaranteeAmount(guaranteeAmount);
		this.fireInsuranceCondition.setPaymentAmount(paymentAmount);
		this.fireInsuranceCondition.setPaymentDay(paymentDay);
		this.fireInsurance.setContractCondition(this.fireInsuranceCondition);
		this.insuranceListImpl.add(this.fireInsurance);

		try {
			insuranceSystemMain.insuranceDao.insert(fireInsurance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
