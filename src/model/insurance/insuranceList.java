package model.insurance;
import java.util.ArrayList;

public interface insuranceList {
	
	public boolean add(insurance insurance);
	public boolean delete(insurance insurance);
	public boolean deleteByID(int insuranceID);
	public insurance searchByID(int insuranceID);	
	public insurance searchByName(String insuranceName);
	public ArrayList<insurance> getInsuranceList();
	public void setInsuranceList(ArrayList<insurance> insuranceList);
	
}