package db;

import java.sql.SQLException;
import java.util.ArrayList;

import model.insurance.contractCondition;

public interface contractConditionDao {
	public void insert(contractCondition contractCondition) throws SQLException;
	public ArrayList<contractCondition> selectAll() throws SQLException;
	public void deleteByID(int id) throws SQLException;
	public void deleteByAll() throws SQLException;
}
