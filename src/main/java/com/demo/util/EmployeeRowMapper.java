package com.demo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Employee;
import com.demo.model.User;

public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setAge(rs.getInt("age"));
		emp.setName(rs.getString("name"));
		emp.setAddress(rs.getString("address"));
		
		return emp;
	}


}
