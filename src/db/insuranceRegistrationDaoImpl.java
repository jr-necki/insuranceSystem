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

import model.insuranceRegistration.insuranceRegistration;

@Repository
public class insuranceRegistrationDaoImpl extends JdbcDaoSupport implements insuranceRegistrationDao {
	@Autowired
    private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public void insert(insuranceRegistration insuranceRegistration) throws SQLException {
		//쿼리 집어넣기
		String query;
		Date date = insuranceRegistration.getRegistrationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.jdbcTemplate=new JdbcTemplate();
		query = "insert into insuranceRegistration(registrationID,customerID,insuranceID,registrationDate) values ("+
				insuranceRegistration.getRegistrationID()+","+
				insuranceRegistration.getCustomerID()+","+
				insuranceRegistration.getInsuranceID()+","+
				"\""+dateFormat.format(date)+"\""+");";
			System.out.println(query);
			this.jdbcTemplate = this.getJdbcTemplate();
			this.jdbcTemplate.execute(query);	
	}

	@Override
	public ArrayList<insuranceRegistration> selectAll() throws SQLException {
		List<insuranceRegistration> insuranceRegistList = new ArrayList<insuranceRegistration>();
		String query="select * from insuranceRegistration;";
		System.out.println(query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<insuranceRegistration> rowMapper = new insuranceRegistrationRowMapper(); 
		
		insuranceRegistList = this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<insuranceRegistration>)insuranceRegistList;
	}
	
	protected class insuranceRegistrationRowMapper implements RowMapper<insuranceRegistration> {
		private List<insuranceRegistration> insuranceRegistList = new ArrayList<insuranceRegistration>();

		public List<insuranceRegistration> getResult() {
			return insuranceRegistList;
		}		
		public insuranceRegistration mapRow(ResultSet resultSet, int rowNum) throws SQLException {		
		insuranceRegistration insuranceRegistration = new insuranceRegistration();
		
		insuranceRegistration.setRegistrationID(Integer.parseInt(resultSet.getString("registrationID")));
		insuranceRegistration.setCustomerID(Integer.parseInt(resultSet.getString("customerID")));
		insuranceRegistration.setRegistrationID(Integer.parseInt(resultSet.getString("insuranceID")));
		insuranceRegistration.setRegistrationDate(resultSet.getDate("registrationDate"));
		
		insuranceRegistList.add(insuranceRegistration);		
		return insuranceRegistration;
		}
	}

	@Override
	public void deleteByID(int id) throws SQLException {
		String query = "delete from insuranceRegistration where registrationID = "
				+ id + ";";
	}

	@Override
	public void deleteByAll() throws SQLException {
		String query;
		query = "set foreign_key_checks = 0;"; // truncate 오류 방지
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
		query = "truncate insuranceRegistration;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
		query = "set foreign_key_checks = 1;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
	}
	
}
