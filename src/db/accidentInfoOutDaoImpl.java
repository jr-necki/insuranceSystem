package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.compensation.accidentInfoOut;
import model.insuranceRegistration.insuranceRegistration;

@Repository
public class accidentInfoOutDaoImpl extends JdbcDaoSupport implements accidentInfoOutDao  {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public accidentInfoOut select(int id) throws SQLException{
		String query;
		query = "select * from accidentInfoOut where accidentID = " + id + ";";
		System.out.println(query);
		
		ResultSet resultSet = null;
		resultSet = (ResultSet) selectAll();
		
		accidentInfoOut accidentInfoOut = new accidentInfoOut();
		
		while(resultSet.next()) {
			accidentInfoOut.setAccidentID(Integer.parseInt(resultSet.getString("accidentID")));
			accidentInfoOut.setAccidentDate(resultSet.getDate("accidentDate"));
			accidentInfoOut.setAccidentPlace(resultSet.getString("accidentPlace"));
			accidentInfoOut.setAccidentTime(resultSet.getString("accidentTime"));
			accidentInfoOut.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
			accidentInfoOut.setDamagedCondition(resultSet.getString("damagedCondition"));
			accidentInfoOut.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
		}
		return accidentInfoOut;
	}
	
	@Override
	public void insert(accidentInfoOut accidentInfoOut) throws SQLException {
		String query;
		Date date = accidentInfoOut.getAccidentDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		query="insert into accidentInfoOut(accidentID,accidentDate,accidentPlace,accidentTime,customerID,damagedCondition,insuranceID) values ("+
		accidentInfoOut.getAccidentID()+","+
		"\""+dateFormat.format(date)+"\""+","+
		"\""+accidentInfoOut.getAccidentPlace()+"\""+","+
		"\""+accidentInfoOut.getAccidentTime()+"\""+","+ 
		"\""+accidentInfoOut.getCustomerID()+"\""+","+
		"\""+accidentInfoOut.getDamagedCondition()+"\""+","+
		accidentInfoOut.getInsuranceID()+");";
		
		System.out.println(query);
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
	}

	@Override
	public ArrayList<accidentInfoOut> selectAll() throws SQLException {
		List<accidentInfoOut> accidentInfoOutList = new ArrayList<accidentInfoOut>();
		String query = "select * from accidentInfoOut;";
		System.out.println(query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<accidentInfoOut> rowMapper = new accidentInfoOutRowMapper(); 
		
		accidentInfoOutList = (List<accidentInfoOut>) this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<accidentInfoOut>)accidentInfoOutList;
	}
	
	protected class accidentInfoOutRowMapper implements RowMapper<accidentInfoOut> {
		private List<accidentInfoOut> accidentInfoOutList = new ArrayList<accidentInfoOut>();

		public List<accidentInfoOut> getResult() {
			return accidentInfoOutList;
		}
		
		public accidentInfoOut mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			accidentInfoOut accidentInfoOut = new accidentInfoOut();
			
			accidentInfoOut.setAccidentID(Integer.parseInt(resultSet.getString("accidentID")));
			accidentInfoOut.setAccidentDate(resultSet.getDate("accidentDate"));
			accidentInfoOut.setAccidentPlace(resultSet.getString("accidentPlace"));
			accidentInfoOut.setAccidentTime(resultSet.getString("accidentTime"));
			accidentInfoOut.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
			accidentInfoOut.setDamagedCondition(resultSet.getString("damagedCondition"));
			accidentInfoOut.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
			accidentInfoOutList.add(accidentInfoOut);
			return accidentInfoOut;
		}
	}

	@Override
	public void deleteByID(int id) throws SQLException {
		
	}

	@Override
	public void deleteByAll() throws SQLException {
		
	}
	public ArrayList<insuranceRegistration> searchID(int id) throws SQLException{
		ArrayList<insuranceRegistration> insuranceRegistrationList = new ArrayList<insuranceRegistration>();
		String query = "select * from insuranceRegistration where customerID = " + id + ";";
		ResultSet resultSet = null;
		resultSet = (ResultSet) selectAll();
		
		while(resultSet.next()) {
			insuranceRegistration insuranceRegistration = new insuranceRegistration();
			
			insuranceRegistration.setRegistrationID(Integer.parseInt(resultSet.getString("registrationID")));
			insuranceRegistration.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
			insuranceRegistration.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
			insuranceRegistration.setRegistrationDate(resultSet.getDate("registrationDate"));			
			insuranceRegistrationList.add(insuranceRegistration);
		}
		return insuranceRegistrationList;
	}

}
