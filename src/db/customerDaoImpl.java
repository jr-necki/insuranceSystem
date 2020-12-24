package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.customer.customer;
import model.customer.customer.familyIllHistory;
import model.customer.customer.illHistory;
import model.customer.customer.job;
import model.customer.property;

@Repository
@Configurable
public class customerDaoImpl extends JdbcDaoSupport implements customerDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public customerDaoImpl() {
	}

	@Override
	public void insert(customer customer) throws SQLException {
		String query;
		if(customer.isGender()) {
			query = "insert into customer(customerID,accidentHistory,address,age,contactNum,gender,identificationNumber,customerName,job,illHistory,familyIllHistory,propertyID)"+ "values (" +
					customer.getCustomerID() + "," + 
					"\"" + customer.getAccidentHistory() + "\"" + "," +
					"\""+ customer.getAddress()+"\""+","+
					customer.getAge() +","+
					"\""+customer.getContactNumber()+ "\""+","+
					1+","+
					"\""+customer.getIdentificationNumber()+"\"" +"," + 
					"\""+customer.getCustomerName()+"\"" + ","+
					"\""+customer.getJob()+ "\""+"," +
					"\""+customer.getIllHistory()+"\""+","+
					"\""+customer.getFamilyIllHistory()+"\"" + ","+
					+customer.getPropertyID()+ ");";
			System.out.println("insertÄõ¸®: "+query);
		}else {
			query = "insert into customer(customerID,accidentHistory,address,age,contactNum,gender,identificationNumber,customerName,job,illHistory,familyIllHistory,propertyID)"+ "values (" +
					customer.getCustomerID() + "," + 
					"\"" + customer.getAccidentHistory() + "\"" + "," +
					"\""+ customer.getAddress()+"\""+","+
					customer.getAge() +","+
					"\""+customer.getContactNumber()+ "\""+","+
					0+","+
					"\""+customer.getIdentificationNumber()+"\"" +"," + 
					"\""+customer.getCustomerName()+"\"" + ","+
					"\""+customer.getJob()+ "\""+"," +
					"\""+customer.getIllHistory()+"\""+","+
					"\""+customer.getFamilyIllHistory()+"\"" + ","+
					+customer.getPropertyID()+ ");";
			System.out.println("insertÄõ¸®: "+query);
		}
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
	}

	@Override
	public ArrayList<customer> selectAll() throws SQLException {
		List<customer> customerList = new ArrayList<customer>();

		String query = "select * from customer;";
		System.out.println("selectAll: " + query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<customer> rowMapper = new customerRowMapper(); 
		
		customerList = (List<customer>) this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<customer>)customerList;
	}
	
	protected class customerRowMapper implements RowMapper<customer> {
		private List<customer> customerList = new ArrayList<customer>();

		public List<customer> getResult() {
			return customerList;
		}
		
		public customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {			
			customer customer = new customer();
			property property = new property();

			customer.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
			customer.setAccidentHistory(resultSet.getString("accidentHistory"));
			customer.setAddress(resultSet.getString("address"));
			customer.setAge(Integer.parseInt(resultSet.getString("age")));
			customer.setContactNumber(resultSet.getString("contactNum"));
			if (resultSet.getString("gender").equals("1")) { // true(1) : ¿©ÀÚ, false(0) : ³²ÀÚ
				customer.setGender(true);
			} else {
				customer.setGender(false);
			}
			customer.setIdentificationNumber(resultSet.getString("identificationNumber"));
			customer.setCustomerName(resultSet.getString("customerName"));
			if (resultSet.getString("job").equals("SOLDIER")) {
				customer.setJob(job.SOLDIER);
			} else if (resultSet.getString("job").equals("DRIVER")) {
				customer.setJob(job.DRIVER);
			} else if (resultSet.getString("job").equals("INTERNALEMPLOYEE")) {
				customer.setJob(job.INTERNALEMPLOYEE);
			} else if (resultSet.getString("job").equals("EXTERNALEMPLOYEE")) {
				customer.setJob(job.EXTERNALEMPLOYEE);
			} else if (resultSet.getString("job").equals("NO_JOB")) {
				customer.setJob(job.NO_JOB);
			}
			if (resultSet.getString("illHistory").equals("NOTHING")) {
				customer.setIllHistory(illHistory.NOTHING);
			} else if (resultSet.getString("illHistory").equals("CANCER")) {
				customer.setIllHistory(illHistory.CANCER);
			} else if (resultSet.getString("illHistory").equals("BLOODPRESURE")) {
				customer.setIllHistory(illHistory.BLOODPRESURE);
			} else if (resultSet.getString("illHistory").equals("GLYCOSURIA")) {
				customer.setIllHistory(illHistory.GLYCOSURIA);
			}
			
			if (resultSet.getString("familyIllHistory").equals("CANCER")) {
				customer.setFamilyIllHistory(familyIllHistory.CANCER);
			} else if (resultSet.getString("familyIllHistory").equals("NOTHING")) {
				customer.setFamilyIllHistory(familyIllHistory.NOTHING);
			} else if (resultSet.getString("familyIllHistory").equals("BLOODPRESURE")) {
				customer.setFamilyIllHistory(familyIllHistory.BLOODPRESURE);
			} else if (resultSet.getString("familyIllHistory").equals("GLYCOSURIA")) {
				customer.setFamilyIllHistory(familyIllHistory.GLYCOSURIA);
			}
			customer.setPropertyID(Integer.parseInt(resultSet.getString("propertyID")));
			customerList.add(customer);
			return customer;
		}
	}

	@Override
	public void deleteByID(int id) throws SQLException {
		String query = "delete from customer where customerID=" + id + ";";
	}

	@Override
	public void deleteByAll() throws SQLException {
		String query;
		query="set foreign_key_checks=0";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate customer;";
		query = "set foreign_key_checks = 1;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
	}

}
