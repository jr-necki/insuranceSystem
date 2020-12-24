package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.insurance.contractCondition;

@Repository
public class contractConditionDaoImpl extends JdbcDaoSupport implements contractConditionDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public int select(int id) throws SQLException{
		String query;
		query = "select * from contractCondition where contractConditionID = " + id + ";";
		System.out.println(query);
		
		this.jdbcTemplate = this.getJdbcTemplate();		
		ResultSet resultSet = (ResultSet) this.jdbcTemplate.queryForList(query);
		
		contractCondition contractCondition = new contractCondition();
		
		while(resultSet.next()) {
			contractCondition.setId(Integer.parseInt(resultSet.getString("id")));
			contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));
			contractCondition.setGuaranteeAmount(Integer.parseInt(resultSet.getString("guaranteeAmount")));
			contractCondition.setPaymentAmount(Integer.parseInt(resultSet.getString("paymentAmount")));
			contractCondition.setPaymentDay(Integer.parseInt(resultSet.getString("paymentDay")));
			contractCondition.setContractConditionID(Integer.parseInt(resultSet.getString("contractConditionID")));
		}
		return contractCondition.getGuaranteeAmount();	
	}

	@Override
	public void insert(contractCondition contractCondition) throws SQLException {
		
	}

	@Override
	public ArrayList<contractCondition> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByAll() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
