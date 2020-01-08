package com.darren.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate npTemplate;

	private SimpleJdbcTemplate simpleJdbcTemplate;


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setNpTemplate(NamedParameterJdbcTemplate npTemplate) {
		this.npTemplate = npTemplate;
	}

	public void setSimpleJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
		this.simpleJdbcTemplate = simpleJdbcTemplate;
	}


	public int saveEmployee(Employee e) {
		String query = "insert into employee values(" + e.getId() + ", '" + e.getName() + "', '" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set" + " name = '" + e.getName() + "', salary = " + e.getSalary() + " where id = "
		    + e.getId();
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id = " + e.getId();
		return jdbcTemplate.update(query);
	}

	// PreparedStatementCallback
	public Boolean saveEmployeeByPreparedStatement(final Employee e) {
		String query = "insert into employee values(?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, e.getId());
				ps.setString(2, e.getName());
				ps.setFloat(3, e.getSalary());
				return ps.execute();
			}
		});
	}

	// ResultSet
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setSalary(rs.getInt(3));
					list.add(e);
				}
				return list;
			}

		});
	}

	// RowMapper
	public List<Employee> getAllEmployeesRowMapper() {
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				return e;
			}

		});
	}

	// NamedParameter
	public void saveByNamedParameter(Employee e) {
		String query = "insert into employee values (:id,:name,:salary)";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", e.getId());
		map.put("name", e.getName());
		map.put("salary", e.getSalary());

		npTemplate.execute(query, map, new PreparedStatementCallback<Object>() {

			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}

		});
	}

	// SimpleJdbcTemplate
	public int updateBySimpleJdbcTemplate(Employee e) {
		String query = "update employee set salary = ? where id = ?";
		return simpleJdbcTemplate.update(query, e.getSalary(), e.getId());
	}
}
