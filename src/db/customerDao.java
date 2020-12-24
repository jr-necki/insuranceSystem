package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.customer.customer;

public interface customerDao {
	public void insert(customer customer) throws SQLException;
	public ArrayList<customer> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;
	
	
}
