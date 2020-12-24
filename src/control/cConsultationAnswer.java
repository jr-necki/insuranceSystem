package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.consultation.consultation;
import model.main.insuranceSystemMain;

public class cConsultationAnswer {
	private consultation consultation; // model
	private ArrayList<consultation> consultationList; // 상담 리스트
	
	public cConsultationAnswer() {
		try {
			this.consultationList = insuranceSystemMain.consultationDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<consultation> getConsultationList() {
		return this.consultationList;
	}

	public consultation showContents(String selectedItem) { // 문의내용확인
		for (consultation consultation: consultationList) {
			if (Integer.parseInt(selectedItem) == consultation.getConsultationID()) {
				this.consultation = consultation;
				return consultation;
			}
		}
		return null;
	}

	public void finishConsultation() { // 상담완료
		// update
		try {
			insuranceSystemMain.consultationDao.update(consultation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
