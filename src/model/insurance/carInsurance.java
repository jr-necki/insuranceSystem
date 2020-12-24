package model.insurance;
import model.customer.customer;

public class carInsurance extends insurance { // 자동차보험
	public enum carType {COMPACT_CAR, MIDSIZE_CAR, FULLSIZE_CAR}
	
	private boolean accidentHistory; // 3년 이내 사고이력
	private int drivingExperience; // 운전경력 // 단위 : 년
	public carType carType; // 차종
	private String carRegistrationNumber; // 자동차 번호

	public carInsurance(){

	}

	public float calculateRate(customer targetCustomer) { // 자동차보험 요율
		float rate = 1;
		
		// car property
		if (targetCustomer.getProperty().getCar()>100000000) rate*=1.5;
		else if (targetCustomer.getProperty().getCar()>50000000) rate*=1.2;
		else rate*=1.1;
		
		// 3년 이내 사고이력
		if (this.accidentHistory) rate*=1.4;
		else rate*=0.8;
		
		// 운전자의 운전경력
		if (this.drivingExperience<1) rate*=1.5;
		else rate*=1.1;

		// 차종
		switch (carType) {
		case COMPACT_CAR: rate*=1.1;
			break;
		case MIDSIZE_CAR: rate*=1.3;
			break;
		case FULLSIZE_CAR: rate*=1.5;
			break;
		default:
			break;
		}
		
		return rate;
	}

	public boolean isAccidentHistory() {
		return accidentHistory;
	}

	public void setAccidentHistory(boolean accidentHistory) {
		this.accidentHistory = accidentHistory;
	}

	public int getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	public carType getCarType() {
		return carType;
	}

	public void setCarType(carType carType) {
		this.carType = carType;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

}