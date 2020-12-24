package db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.consultation.consultation;

@Repository
public class consultationDaoImpl extends JdbcDaoSupport implements consultationDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void insert(consultation consultation) throws SQLException {
		// 쿼리 집어넣기
		String query;
		query = "insert into consultation(consultationID,enquirerName,contactNumber,inquiry) values (" +
				consultation.getConsultationID() + "," +
				"\"" + consultation.getEnquirerName() + "\"" + "," +
				"\"" + consultation.getContactNumber() + "\"" + "," +
				"\"" + consultation.getInquiry() +  "\"" + ");" ;
		System.out.println(query); // 쿼리 제대로 찍혔는지 확인
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
	}

	@Override
	public void update(consultation consultation) throws SQLException {
		String query;
		query = "update consultation set enquirerName = " + "\"" + consultation.getEnquirerName() +
		"(상담완료)" + "\"" + " where consultationID = " + consultation.getConsultationID() + ";" ;
		System.out.println(query);
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);		
	}

	public ArrayList<consultation> selectAll() throws SQLException {
		List<consultation> consultationList = new ArrayList<consultation>();
		
		String query = "select * from consultation;";
		System.out.println(query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<consultation> rowMapper = new consultationRowMapper(); 
		
		consultationList = this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<consultation>)consultationList;
	}
	
	protected class consultationRowMapper implements RowMapper<consultation> {
		private List<consultation> consultationList = new ArrayList<consultation>();

		public List<consultation> getResult() {
			return consultationList;
		}
		
		public consultation mapRow(ResultSet resultSet, int rowNum) throws SQLException {		
			consultation consultation = new consultation();

			consultation.setConsultationID(Integer.parseInt(resultSet.getString("consultationID")));
			consultation.setEnquirerName((resultSet.getString("enquirerName")));
			consultation.setContactNumber((resultSet.getString("contactNumber")));
			consultation.setInquiry((resultSet.getString("inquiry")));
			consultationList.add(consultation);		
			return consultation;
		}
	}
	
	@Override
	public void deleteByID(int id) throws SQLException {		
	}
	
	public void deleteByAll() throws SQLException {
	}

}
