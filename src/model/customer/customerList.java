package model.customer;
import java.util.ArrayList;

public interface customerList {

	public boolean add(customer customer);
	public boolean delete(customer customer);
	public boolean deleteByID(int customerID);
	public customer searchByID(int customerID);	
	public customer searchByName(String customerName);
	public ArrayList<customer> getCustomerList();
	public void setCustomerList(ArrayList<customer> customerList);
	
}