package control;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.compensation.accidentInfoOut;
import model.insuranceRegistration.insuranceRegistration;
import model.main.insuranceSystemMain;

public class cReception { // 접수하기
	private accidentInfoOut accidentInfoOut; // model
	
	private ArrayList<accidentInfoOut> accidentInfoOutList;
	private String ids="";
	
	public String checkInsuranceID(int id) { // 가입된 보험 확인
		ids="";
		try {			
			ArrayList<insuranceRegistration>ins=insuranceSystemMain.insuranceRegistrationDao.selectAll();
			for(insuranceRegistration a: ins) {
				if(a.getCustomerID()==id) {
					ids+=(a.getRegistrationID()+" ");
				}
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ids;
		
	}


	public void makeReception(String time, String place, String date, int id1, String status, int insuranceID) {
		accidentInfoOut = new accidentInfoOut();
		try {
			this.accidentInfoOutList = insuranceSystemMain.accidentInfoOutDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date to = null;
		
		try {
			to = (Date) transFormat.parse(date);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		accidentInfoOut.setAccidentID(accidentInfoOutList.size()+1);
		accidentInfoOut.setAccidentTime(time);
		accidentInfoOut.setAccidentPlace(place);
		
		accidentInfoOut.setAccidentDate(to);
		accidentInfoOut.setCustomerID(id1);
		accidentInfoOut.setDamagedCondition(status);
		accidentInfoOut.setInsuranceID(insuranceID);
		this.accidentInfoOutList.add(accidentInfoOut);

		try {
			insuranceSystemMain.accidentInfoOutDao.insert(accidentInfoOut);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
