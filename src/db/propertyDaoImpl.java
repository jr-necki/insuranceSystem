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

import model.customer.property;

@Repository
public class propertyDaoImpl extends JdbcDaoSupport implements propertyDao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public propertyDaoImpl() {
	}

	@Override
	public void insert(property property) throws SQLException {
		String query;
		query="insert into property(id,car,house)"
				+"values("+property.getID()+","+"\""+property.getHouse()+"\""+","+"\""
				+property.getCar()+"\""+");";
		System.out.println(query);
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
	}

	@Override
	public ArrayList<property> selectAll() throws SQLException {
		List<property> propertyList = new ArrayList<property>();

		String query = "select * from property;";
		System.out.println("selectAll: " + query);
		
		this.jdbcTemplate = this.getJdbcTemplate();
		RowMapper<property> rowMapper = new propertyRowMapper(); 
		
		propertyList = (List<property>) this.jdbcTemplate.query(query, rowMapper);
		return (ArrayList<property>)propertyList;
	}
	
	protected class propertyRowMapper implements RowMapper<property> {
		private List<property> propertyList = new ArrayList<property>();

		public List<property> getResult() {
			return propertyList;
		}
		
		public property mapRow(ResultSet resultSet, int rowNum) throws SQLException {		
			property property=new property();
		
			property.setID(Integer.parseInt(resultSet.getString("id")));
			property.setHouse(Integer.parseInt(resultSet.getString("house")));
			property.setCar(Integer.parseInt(resultSet.getString("car")));			
			propertyList.add(property);
			
			return property;
		}
	}

	@Override
	public void deleteByID(int id) throws SQLException {
		String query="delete from property where id="+id+";";
		
	}

	@Override
	public void deleteByAll() throws SQLException {
		String query;
		query="set foreign_key_checks=0";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);	
		query = "truncate property;";
		query = "set foreign_key_checks = 1;";
		this.jdbcTemplate = this.getJdbcTemplate();
		this.jdbcTemplate.execute(query);			
	}

}
