package db;
import java.sql.SQLException;
import java.util.ArrayList;

import model.consultation.consultation;

public interface consultationDao {
	
	public void insert(consultation consultation) throws SQLException;
	public void update(consultation consultation) throws SQLException;
	public ArrayList<consultation> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;

}
