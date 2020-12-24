package model.insurance;
import model.customer.customer;

public class cancerInsurance extends insurance { // 암보험

	public cancerInsurance(){

	}

	public float calculateRate(customer targetCustomer) {
		float rate = 1;
		
		// 성별
		if (targetCustomer.isGender()) rate*=1.3; // female // 최근 여성의 암 발생률 증가
		else rate*=1.1; // male
		
		// 나이
		if (targetCustomer.getAge()<30) rate*=1.1;
		else if (targetCustomer.getAge()<50) rate*=1.2;
		else if (targetCustomer.getAge()<70) rate*=1.3;
		else rate*=1.4;
		
		// 가족력
		switch(targetCustomer.getFamilyIllHistory()) {
		case NOTHING: rate*=0.9;
		break;
		case CANCER: rate*=1.5;
		break;
		default:
			break;
		}
		
		return rate;
	}
	
}