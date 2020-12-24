package model.consultation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class consultation {
	
	private int consultationID; // 상담 id
	private String enquirerName; // 문의자 이름
	private String contactNumber; // 문의자 전화번호
	private String inquiry = ""; // 문의내용

	public int getConsultationID() {
		return consultationID;
	}
	public void setConsultationID(int consultationID) {
		this.consultationID = consultationID;
	}
	public String getEnquirerName() {
		return enquirerName;
	}
	public void setEnquirerName(String enquirerName) {
		this.enquirerName = enquirerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getInquiry() {
		return inquiry;
	}
	public void setInquiry(String inquiry) {
		this.inquiry = inquiry;
	}
	
}
