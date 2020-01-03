package com.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Employee;
import com.demo.util.EmployeeRowMapper;

@Repository
public class EmployeeDao {
	
	private DataSource datasource;
	public JdbcTemplate jdbcTemplateObject;
	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		this.jdbcTemplateObject = new JdbcTemplate(this.datasource);
	}


	public void insertEmployee(Employee emp) {
		final String SQL = "insert into EMPLOYEE (name, address, AGE) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, emp.getName(), emp.getAddress(), emp.getAge());
	}
//
//	public void deleteEmployee(int id) {
//		String SQL = "delete from EMPLOYEE where id = ?";
//		int update = jdbcTemplateObject.update(SQL, id);
//		System.out.println(update+" Record(s) deleted with ID = " + id );
//	}
//
//	public void updateEmployee(int id, int age) {
//		String SQL = "update EMPLOYEE set age = ? where id = ?";
//		int update = jdbcTemplateObject.update(SQL, age, id);
//		System.out.println(update+" Record(s) updated with ID = " + id );
//	}
//
	public List<Employee> getEmployees() {
		String SQL = "select * from EMPLOYEE";
		List <Employee> emps = jdbcTemplateObject.query(SQL, new EmployeeRowMapper());
		return emps;
	}
//
//	public Employee getEmployee(int id){
//		String SQL = "select * from EMPLOYEE where id = ?";
//		return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EmployeeRowMapper());
//	}

}
