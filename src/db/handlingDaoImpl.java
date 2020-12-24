package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.compensation.handlingAccident;

@Repository
public class handlingDaoImpl extends JdbcDaoSupport implements handlingDao{
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public void insert(handlingAccident handlingAccident) throws SQLException {
		String query;
		
		query = "insert into handling(handlingID,accidentID,customerID,insuranceID,amount) values("+
				handlingAccident.getHandlingID()+","+
				handlingAccident.getAccidentID()+","+
				handlingAccident.getCustomerID()+","+
				handlingAccident.getInsuranceID()+","+
				handlingAccident.getAmount()+");";
		System.out.println(query);
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
	}

	@Override
	public void update(handlingAccident handlingAccident) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<handlingAccident> selectAll() throws SQLException {
		ArrayList<handlingAccident>handlingAccidentList=new ArrayList<handlingAccident>();
		String query="select * from handling";
		System.out.println(query);
		ResultSet resultSet = null;
		resultSet = (ResultSet) selectAll();
		
		while(resultSet.next()) {
			handlingAccident handlingAccident=new handlingAccident();
			
			handlingAccident.setHandlingID(Integer.parseInt(resultSet.getString("handlingID")));
			handlingAccident.setAccidentID(Integer.parseInt(resultSet.getString("accidentID")));
			handlingAccident.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
			handlingAccident.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
			handlingAccident.setAmount(Integer.parseInt(resultSet.getString("amount")));
			handlingAccidentList.add(handlingAccident);
		}	
		return handlingAccidentList;
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
