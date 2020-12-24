package model.insurance;
import model.customer.customer;

public abstract class insurance {
	public enum insuranceType {LIFEINSURANCE, CARINSURANCE, CANCERINSURANCE, FIREINSURANCE}

	private int insuranceID;
	private String insuranceName;
	public insuranceType insuranceType;
	private String description;
	private contractCondition contractCondition;
	private int contractConditionID; 
	
	public int getContractConditionID() {
		return contractConditionID;
	}

	public void setContractConditionID(int contractConditionID) {
		this.contractConditionID = contractConditionID;
	}

	public insurance(){
	}
	
	abstract public float calculateRate(customer targetCustomer); // 보험요율 // 보험마다 다르다

	public int getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(int insuranceID) {
		this.insuranceID = insuranceID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public insuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(insuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public contractCondition getContractCondition() {
		return contractCondition;
	}

	public void setContractCondition(contractCondition contractCondition) {
		this.contractCondition = contractCondition;
	}
	
}