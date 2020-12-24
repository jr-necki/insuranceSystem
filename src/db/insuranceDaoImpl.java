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

import model.insurance.cancerInsurance;
import model.insurance.carInsurance;
import model.insurance.contractCondition;
import model.insurance.fireInsurance;
import model.insurance.insurance;
import model.insurance.insurance.insuranceType;
import model.insurance.lifeInsurance;

@Repository
public class insuranceDaoImpl extends JdbcDaoSupport implements insuranceDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public int amount(int id) throws SQLException{
		int amount = 0;
		String query;
		query = "select * from insurance where insuranceID = " + id + ";";
		System.out.println(query);
		
		ResultSet resultSet = null;
		resultSet = (ResultSet) selectAll();
		
		insurance cancerInsurance = new cancerInsurance();
		insurance carInsurance = new carInsurance();
		insurance fireInsurance = new fireInsurance();
		insurance lifeInsurance = new lifeInsurance();
		contractCondition contractCondition = new contractCondition();
		
		while (resultSet.next()) {
			if (resultSet.getString("insuranceType").equals("CANCERINSURANCE")) {
				//contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));
				cancerInsurance.setContractCondition(contractCondition);
				cancerInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				cancerInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				cancerInsurance.setContractConditionID(Integer.parseInt(resultSet.getString("contractConditionID")));
				contractConditionDaoImpl contractConditionDaoImpl=new contractConditionDaoImpl();
				amount=contractConditionDaoImpl.select(cancerInsurance.getContractConditionID());
				
			} else if (resultSet.getString("insuranceType").equals("CARINSURANCE")) {
				//contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));				
				carInsurance.setContractCondition(contractCondition);
				carInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				carInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				carInsurance.setContractConditionID(Integer.parseInt(resultSet.getString("contractConditionID")));
				contractConditionDaoImpl contractConditionDaoImpl=new contractConditionDaoImpl();
				amount=contractConditionDaoImpl.select(carInsurance.getContractConditionID());
				
			} else if (resultSet.getString("insuranceType").equals("FIREINSURANCE")) {							
				fireInsurance.setContractCondition(contractCondition);
				fireInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				fireInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				fireInsurance.setContractConditionID(Integer.parseInt(resultSet.getString("contractConditionID")));
				contractConditionDaoImpl contractConditionDaoImpl=new contractConditionDaoImpl();
				amount=contractConditionDaoImpl.select(fireInsurance.getContractConditionID());
				
			} else if (resultSet.getString("insuranceType").equals("LIFEINSURANCE")) {						
				lifeInsurance.setContractCondition(contractCondition);
				lifeInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				lifeInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				lifeInsurance.setContractConditionID(Integer.parseInt(resultSet.getString("contractConditionID")));
				contractConditionDaoImpl contractConditionDaoImpl=new contractConditionDaoImpl();
				amount=contractConditionDaoImpl.select(lifeInsurance.getContractConditionID());
			}
		}
		System.out.println(amount);
		return amount;
	}
	
	public void insert(insurance insurance) throws SQLException {
		// 쿼리 집어넣기
		String query;
		
		// contractCondition
		Date date = insurance.getContractCondition().getExpirationDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		query = "insert into contractCondition(expirationDate,guaranteeAmount,paymentAmount,paymentDay,contractConditionID) values (" +
				"\"" + dateFormat.format(date) + "\"" + "," +
				insurance.getContractCondition().getGuaranteeAmount() + "," +
				insurance.getContractCondition().getPaymentAmount() + "," +
				insurance.getContractCondition().getPaymentDay() + "," +
				insurance.getContractCondition().getContractConditionID() + ");" ;
		System.out.println(query); // 쿼리 제대로 찍혔는지 확인
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);			
	
		// insurance
		query = "insert into insurance(insuranceName,insuranceType,description,contractConditionID) values (" +
				"\"" + insurance.getInsuranceName() + "\"" + "," +
				"\"" + insurance.getInsuranceType() + "\"" + "," +
				"\"" + insurance.getDescription() + "\"" + "," +
				insurance.getContractCondition().getContractConditionID() + ");" ;	
		System.out.println(query);
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);		
	
		// insurance 종류 별
		if (insurance.insuranceType==insuranceType.CANCERINSURANCE) {			
			query = "insert into cancerInsurance(insuranceID) values (" +
					insurance.getInsuranceID() + ");" ;	
			System.out.println(query); 
			this.jdbcTemplate = this.getJdbcTemplate();
			this.jdbcTemplate.execute(query);				
		} else if (insurance.insuranceType==insuranceType.CARINSURANCE) {		
			query = "insert into carInsurance(accidentHistory,drivingExperience,carType,carRegistrationNumber,insuranceID) values (" +
					((carInsurance)insurance).isAccidentHistory() + "," +
					((carInsurance)insurance).getDrivingExperience() + "," +
					"\"" + ((carInsurance)insurance).getCarType() + "\"" + "," +
					"\"" + ((carInsurance)insurance).getCarRegistrationNumber() + "\"" + "," +
					insurance.getInsuranceID() + ");" ;	
			System.out.println(query);
			this.jdbcTemplate = this.getJdbcTemplate();
			this.jdbcTemplate.execute(query);	
		} else if (insurance.insuranceType==insuranceType.FIREINSURANCE) {
			query = "insert into fireInsurance(buildingGrade,buildingSurfaceArea,insuranceID) values (" +
					((fireInsurance)insurance).getBuildingGrade() + "," +
					((fireInsurance)insurance).getBuildingSurfaceArea() + "," +
					insurance.getInsuranceID() + ");" ;	
			System.out.println(query); 
			this.jdbcTemplate = this.getJdbcTemplate();
			this.jdbcTemplate.execute(query);		
		} else { // lifeInsurance
			query = "insert into lifeInsurance(insuranceID) values (" +
					insurance.getInsuranceID() + ");" ;	
			System.out.println(query); 
			this.jdbcTemplate = this.getJdbcTemplate();
			this.jdbcTemplate.execute(query);	
		}
	}

	public ArrayList<insurance> selectAll() throws SQLException {
		List<insurance> insuranceList = new ArrayList<insurance>();
		
		String query = "select insurance.insuranceType, insurance.insuranceID, insurance.insuranceName, contractCondition.expirationDate "
				+ "from insurance, contractCondition " +
				"where insurance.contractConditionID = contractCondition.contractConditionID;";
		System.out.println(query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<insurance> rowMapper = new InsuranceRowMapper(); 
		
		insuranceList = this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<insurance>)insuranceList;
	}
	
	protected class InsuranceRowMapper implements RowMapper<insurance> {
		private List<insurance> insuranceList = new ArrayList<insurance>();

		public List<insurance> getResult() {
			return insuranceList;
		}
		
		public insurance mapRow(ResultSet resultSet, int rowNum) throws SQLException {		
			insurance cancerInsurance = new cancerInsurance();
			insurance carInsurance = new carInsurance();
			insurance fireInsurance = new fireInsurance();
			insurance lifeInsurance = new lifeInsurance();
			contractCondition contractCondition = new contractCondition();
			
			if (resultSet.getString("insuranceType").equals("CANCERINSURANCE")) {
				contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));
				cancerInsurance.setContractCondition(contractCondition);
				cancerInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				cancerInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				insuranceList.add(cancerInsurance);
				return cancerInsurance;
			} else if (resultSet.getString("insuranceType").equals("CARINSURANCE")) {
				contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));				
				carInsurance.setContractCondition(contractCondition);
				carInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				carInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				insuranceList.add(carInsurance);
				return carInsurance;
			} else if (resultSet.getString("insuranceType").equals("FIREINSURANCE")) {
				contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));				
				fireInsurance.setContractCondition(contractCondition);
				fireInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				fireInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				insuranceList.add(fireInsurance);
				return fireInsurance;
			} else if (resultSet.getString("insuranceType").equals("LIFEINSURANCE")) {
				contractCondition.setExpirationDate(resultSet.getDate("expirationDate"));				
				lifeInsurance.setContractCondition(contractCondition);
				lifeInsurance.setInsuranceID(Integer.parseInt(resultSet.getString("insuranceID")));
				lifeInsurance.setInsuranceName(resultSet.getString("insuranceName"));
				insuranceList.add(lifeInsurance);
				return lifeInsurance;
			}
			return null;
		}
	}

	
	public void deleteByID(int id) throws SQLException {
		String query = "delete from insurance where insuranceID = "
				+ id + ";";
	}
	
	public void deleteByAll() throws SQLException {
		String query;
		query = "set foreign_key_checks = 0;"; // truncate 오류 방지
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate cancerInsurance;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate carInsurance;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate fireInsurance;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate lifeInsurance;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate Insurance;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "truncate contractCondition;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
		query = "set foreign_key_checks = 1;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);
	}
	
}
