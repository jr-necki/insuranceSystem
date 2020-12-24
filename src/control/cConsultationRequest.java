package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.consultation.consultation;
import model.main.insuranceSystemMain;

public class cConsultationRequest {
	private consultation consultation; // model
	private ArrayList<consultation> consultationList; // 상담 리스트

	public cConsultationRequest() {
		try {
			this.consultationList = insuranceSystemMain.consultationDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveContents(String name, String contactNum, String inquiryDetails) { // 저장
		this.consultation = new consultation();
		this.consultation.setConsultationID(consultationList.size()+1);
		this.consultation.setEnquirerName(name);
		this.consultation.setContactNumber(contactNum);
		this.consultation.setInquiry(inquiryDetails);
	}
	
	public void requestConsultation() { // 상담신청
		// insert
		try {
			insuranceSystemMain.consultationDao.insert(consultation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
