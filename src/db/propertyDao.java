package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.customer.property;

public interface propertyDao {
	public void insert(property property) throws SQLException;
	public ArrayList<property> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;
	
}
