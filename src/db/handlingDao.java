package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.compensation.handlingAccident;

public interface handlingDao {
	public void insert(handlingAccident handlingAccident) throws SQLException;
	public void update(handlingAccident handlingAccident) throws SQLException;
	public ArrayList<handlingAccident> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;
}
