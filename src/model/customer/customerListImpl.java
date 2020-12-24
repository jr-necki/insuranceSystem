package model.customer;

import java.sql.SQLException;
import java.util.ArrayList;

import model.main.insuranceSystemMain;

public class customerListImpl implements customerList {
	private ArrayList<customer> customerList;

	public customerListImpl() {
		try {
			this.customerList =  insuranceSystemMain.customerDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean add(customer customer) {
		this.customerList.add(customer);
		return true;
	}

	public boolean delete(customer customer) {
		this.customerList.remove(customer);
		return true;
	}

	public boolean deleteByID(int customerID) {
		return true;
	}

	public customer searchByID(int customerID) {
		for (customer customer : this.customerList) {
			if (customer.getCustomerID() == customerID) {
				return customer;
			}
		}
		return null;
	}

	public customer searchByName(String customerName) {
		for (customer customer : this.customerList) {
			if (customer.getCustomerName() == customerName) {
				return customer;
			}
		}
		return null;
	}

	public ArrayList<customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<customer> customerList) {
		this.customerList = customerList;
	}

}
