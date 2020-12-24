package db;
import java.sql.SQLException;
import java.util.ArrayList;

import model.insurance.insurance;

public interface insuranceDao {
	
	public void insert(insurance insurance) throws SQLException;
	public ArrayList<insurance> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;

}
