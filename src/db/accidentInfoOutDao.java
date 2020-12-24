package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.compensation.accidentInfoOut;

public interface accidentInfoOutDao {
	public void insert(accidentInfoOut accidentInfoOut) throws SQLException;
	public ArrayList<accidentInfoOut> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;
}
