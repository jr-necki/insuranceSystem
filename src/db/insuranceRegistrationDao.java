package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.insuranceRegistration.insuranceRegistration;


public interface insuranceRegistrationDao {
	public void insert(insuranceRegistration insuranceRegistration ) throws SQLException;
	public ArrayList<insuranceRegistration> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;


}
