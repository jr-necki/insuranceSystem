package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.compensation.accidentInfoOut;
import model.compensation.handlingAccident;
import model.insurance.insurance;
import model.insurance.insuranceList;
import model.insurance.insuranceListImpl;
import model.main.insuranceSystemMain;

public class cHandling { // 처리하기
	private accidentInfoOut accidentInfoOut; // model

	private ArrayList<accidentInfoOut> accidentInfoOutList;
	private insuranceList insuranceListImpl;	
	private insurance insurance;
	private int amount;
	private int id;

	public cHandling() {
		try {
			this.accidentInfoOutList = insuranceSystemMain.accidentInfoOutDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.insuranceListImpl = new insuranceListImpl();
	}
	
	public accidentInfoOut checkID(int id) { // id 체크
		this.id = id;
		for(accidentInfoOut a: accidentInfoOutList) {
			if(a.getAccidentID()==id) {
				accidentInfoOut = a;
			}
		}
		return accidentInfoOut;
	}
	
	public int showAmount(int insuranceID) { // 보장액
		insuranceListImpl = new insuranceListImpl();
		
		for(insurance i: insuranceListImpl.getInsuranceList()) {
			if(i.getInsuranceID()==insuranceID) {
				this.insurance=i;
			}
		}
		this.amount = this.insurance.getContractCondition().getGuaranteeAmount();
		return amount;
	}
	
	public handlingAccident save(int accidentID, int customerID, int insuranceID, int amount) {
		handlingAccident handlingAccident = new handlingAccident();
		handlingAccident.setAccidentID(accidentID);
		handlingAccident.setCustomerID(customerID);
		handlingAccident.setInsuranceID(insuranceID);
		handlingAccident.setAmount(amount);
		
		try {
			insuranceSystemMain.handlingDao.insert(handlingAccident);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return handlingAccident;
	}
	
}
