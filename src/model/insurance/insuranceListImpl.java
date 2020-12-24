package model.insurance;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.insurance.carInsurance.carType;
import model.insurance.insurance.insuranceType;

public class insuranceListImpl implements insuranceList {

	private ArrayList<insurance> insuranceList;
	private insurance lifeInsurance;
	private insurance fireInsurance;
	private insurance cancerInsurance;
	private insurance carInsurance;
	private contractCondition lifeInsuranceCondition;
	private contractCondition fireInsuranceCondition;
	private contractCondition cancerInsuranceCondition;
	private contractCondition carInsuranceCondition;

	public insuranceListImpl(){
		this.insuranceList = new ArrayList<insurance>();
		Date newDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
		// 이전 보험리스트에 저장된 보험들
		File file = new File("insuranceList/");
		File[] subFiles = file.listFiles();
		
		for (int i=0; i<subFiles.length; i++) {
			if (subFiles[i].getName().contains("LIFEINSURANCE")) {
				try {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(subFiles[i]);
					while (scanner.hasNext()) {
						this.lifeInsurance = new lifeInsurance();
						this.lifeInsuranceCondition = new contractCondition();
						
						// insurance
						this.lifeInsurance.setInsuranceID(scanner.nextInt());
						scanner.nextLine();
						this.lifeInsurance.setInsuranceName(scanner.nextLine());
						this.lifeInsurance.setInsuranceType(insuranceType.valueOf(scanner.nextLine()));
						this.lifeInsurance.setDescription(scanner.nextLine());
						// contractCondition
						this.lifeInsuranceCondition.setContractConditionID(scanner.nextInt());
						scanner.nextLine();
						String date = scanner.nextLine();
						try {
							newDate = dateFormat.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.lifeInsuranceCondition.setExpirationDate(newDate);
						this.lifeInsuranceCondition.setGuaranteeAmount(scanner.nextInt());
						scanner.nextLine();
						this.lifeInsuranceCondition.setPaymentAmount(scanner.nextInt());
						scanner.nextLine();
						this.lifeInsuranceCondition.setPaymentDay(scanner.nextInt());
						this.lifeInsurance.setContractCondition(this.lifeInsuranceCondition);
						
						this.insuranceList.add(this.lifeInsurance);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} else if (subFiles[i].getName().contains("FIREINSURANCE")) {
				try {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(subFiles[i]);
					while (scanner.hasNext()) {
						this.fireInsurance = new fireInsurance();
						this.fireInsuranceCondition = new contractCondition();

						// insurance 
						this.fireInsurance.setInsuranceID(scanner.nextInt());
						scanner.nextLine();
						this.fireInsurance.setInsuranceName(scanner.nextLine());
						this.fireInsurance.setInsuranceType(insuranceType.valueOf(scanner.nextLine()));
						this.fireInsurance.setDescription(scanner.nextLine());
						((fireInsurance)this.fireInsurance).setBuildingGrade(scanner.nextInt());
						scanner.nextLine();
						((fireInsurance)this.fireInsurance).setBuildingSurfaceArea(scanner.nextInt());
						scanner.nextLine();
						// contractCondition
						this.fireInsuranceCondition.setContractConditionID(scanner.nextInt());
						scanner.nextLine();
						String date = scanner.nextLine();
						Date expirationDate = new Date();
						try {
							expirationDate = dateFormat.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.fireInsuranceCondition.setExpirationDate(expirationDate);
						this.fireInsuranceCondition.setGuaranteeAmount(scanner.nextInt());
						scanner.nextLine();
						this.fireInsuranceCondition.setPaymentAmount(scanner.nextInt());
						scanner.nextLine();
						this.fireInsuranceCondition.setPaymentDay(scanner.nextInt());
						this.fireInsurance.setContractCondition(this.fireInsuranceCondition);
						
						this.insuranceList.add(this.fireInsurance);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} else if (subFiles[i].getName().contains("CANCERINSURANCE")) {
				try {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(subFiles[i]);
					while (scanner.hasNext()) {
						this.cancerInsurance = new cancerInsurance();
						this.cancerInsuranceCondition = new contractCondition();
						
						// insurance
						this.cancerInsurance.setInsuranceID(scanner.nextInt());
						scanner.nextLine();
						this.cancerInsurance.setInsuranceName(scanner.nextLine());
						this.cancerInsurance.setInsuranceType(insuranceType.valueOf(scanner.nextLine()));
						this.cancerInsurance.setDescription(scanner.nextLine());
						// contractCondition
						this.cancerInsuranceCondition.setContractConditionID(scanner.nextInt());
						scanner.nextLine();
						String date = scanner.nextLine();
						Date expirationDate = new Date();
						try {
							expirationDate = dateFormat.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.cancerInsuranceCondition.setExpirationDate(expirationDate);
						this.cancerInsuranceCondition.setGuaranteeAmount(scanner.nextInt());
						scanner.nextLine();
						this.cancerInsuranceCondition.setPaymentAmount(scanner.nextInt());
						scanner.nextLine();
						this.cancerInsuranceCondition.setPaymentDay(scanner.nextInt());
						this.cancerInsurance.setContractCondition(this.cancerInsuranceCondition);
						
						this.insuranceList.add(this.cancerInsurance);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} else if (subFiles[i].getName().contains("CARINSURANCE")) {
				try {
					@SuppressWarnings("resource")
					Scanner scanner = new Scanner(subFiles[i]);
					while (scanner.hasNext()) {
						this.carInsurance = new carInsurance();
						this.carInsuranceCondition = new contractCondition();
						
						// insurance
						this.carInsurance.setInsuranceID(scanner.nextInt());
						scanner.nextLine();
						this.carInsurance.setInsuranceName(scanner.nextLine());
						this.carInsurance.setInsuranceType(insuranceType.valueOf(scanner.nextLine()));
						this.carInsurance.setDescription(scanner.nextLine());
						boolean accident;
						if (scanner.nextLine().equals("있다")) accident = true;
						else accident = false;
						((carInsurance)this.carInsurance).setAccidentHistory(accident);
						((carInsurance)this.carInsurance).setDrivingExperience(scanner.nextInt());
						scanner.nextLine();
						((carInsurance)this.carInsurance).setCarType(carType.valueOf(scanner.nextLine()));
						((carInsurance)this.carInsurance).setCarRegistrationNumber(scanner.nextLine());
						// contractCondition
						this.carInsuranceCondition.setContractConditionID(scanner.nextInt());
						scanner.nextLine();
						String date = scanner.nextLine();
						Date expirationDate = new Date();
						try {
							expirationDate = dateFormat.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						this.carInsuranceCondition.setExpirationDate(expirationDate);
						this.carInsuranceCondition.setGuaranteeAmount(scanner.nextInt());
						scanner.nextLine();
						this.carInsuranceCondition.setPaymentAmount(scanner.nextInt());
						scanner.nextLine();
						this.carInsuranceCondition.setPaymentDay(scanner.nextInt());
						this.carInsurance.setContractCondition(this.carInsuranceCondition);
						
						this.insuranceList.add(this.carInsurance);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}
	}

	public boolean add(insurance insurance){
		this.insuranceList.add(insurance);
		
		// 텍스트파일에 저장
		if (insurance.getInsuranceType().equals(insuranceType.LIFEINSURANCE) 
				| insurance.getInsuranceType().equals(insuranceType.CANCERINSURANCE)) {
			try {
				writeToFileLC(insurance, insurance.getInsuranceType().toString(), insurance.getInsuranceID());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (insurance.getInsuranceType().equals(insuranceType.FIREINSURANCE)) {
			try {
				writeToFileFIRE(insurance, insurance.getInsuranceType().toString(), insurance.getInsuranceID());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (insurance.getInsuranceType().equals(insuranceType.CARINSURANCE)) {
			try {
				writeToFileCAR(insurance, insurance.getInsuranceType().toString(), insurance.getInsuranceID());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}

	public boolean delete(insurance insurance){
		this.insuranceList.remove(insurance);
		return true;
	}
	
	public boolean deleteByID(int insuranceID){
		
		return true;
	}

	public insurance searchByID(int insuranceID){
		for (insurance insurance : this.insuranceList) {
			if (insurance.getInsuranceID()==insuranceID) {
				return insurance;
			}
		}
		return null;
	}
	
	public insurance searchByName(String insuranceName){
		for (insurance insurance : this.insuranceList) {
			if (insurance.getInsuranceName()==insuranceName) {
				return insurance;
			}
		}
		return null;
	}

	public ArrayList<insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(ArrayList<insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}
	
	public void writeToFileLC(insurance insurance, String insType, int insID) throws IOException { // 생명, 암
		File file = new File("insuranceList/" + insType + insID);
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		// insurance
		printWriter.println(insurance.getInsuranceID());
		printWriter.println(insurance.getInsuranceName());
		printWriter.println(insurance.getInsuranceType());
		printWriter.println(insurance.getDescription());
		// contractCondition
		printWriter.println(insurance.getContractCondition().getContractConditionID());
		Date date = insurance.getContractCondition().getExpirationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		printWriter.println(dateFormat.format(date));
		printWriter.println(insurance.getContractCondition().getGuaranteeAmount());
		printWriter.println(insurance.getContractCondition().getPaymentAmount());
		printWriter.println(insurance.getContractCondition().getPaymentDay());
		fileWriter.close();
	}
	
	public void writeToFileFIRE(insurance insurance, String insType, int insID) throws IOException { // 화재
		File file = new File("insuranceList/" + insType + insID);
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		// insurance
		printWriter.println(insurance.getInsuranceID());
		printWriter.println(insurance.getInsuranceName());
		printWriter.println(insurance.getInsuranceType());
		printWriter.println(insurance.getDescription());
		printWriter.println(((fireInsurance)insurance).getBuildingGrade());
		printWriter.println(((fireInsurance)insurance).getBuildingSurfaceArea());
		// contractCondition
		printWriter.println(insurance.getContractCondition().getContractConditionID());
		Date date = insurance.getContractCondition().getExpirationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		printWriter.println(dateFormat.format(date));
		printWriter.println(insurance.getContractCondition().getGuaranteeAmount());
		printWriter.println(insurance.getContractCondition().getPaymentAmount());
		printWriter.println(insurance.getContractCondition().getPaymentDay());
		fileWriter.close();	
	}
	
	public void writeToFileCAR(insurance insurance, String insType, int insID) throws IOException { // 자동차
		File file = new File("insuranceList/" + insType + insID);	
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		// insurance
		printWriter.println(insurance.getInsuranceID());
		printWriter.println(insurance.getInsuranceName());
		printWriter.println(insurance.getInsuranceType());
		printWriter.println(insurance.getDescription());
		boolean accident = ((carInsurance)insurance).isAccidentHistory();
		if (accident) printWriter.println("있다");
		else printWriter.println("없다");
		printWriter.println(((carInsurance)insurance).getDrivingExperience());
		printWriter.println(((carInsurance)insurance).getCarType());
		printWriter.println(((carInsurance)insurance).getCarRegistrationNumber());
		// contractCondition
		printWriter.println(insurance.getContractCondition().getContractConditionID());
		Date date = insurance.getContractCondition().getExpirationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		printWriter.println(dateFormat.format(date));
		printWriter.println(insurance.getContractCondition().getGuaranteeAmount());
		printWriter.println(insurance.getContractCondition().getPaymentAmount());
		printWriter.println(insurance.getContractCondition().getPaymentDay());
		fileWriter.close();
	}

}