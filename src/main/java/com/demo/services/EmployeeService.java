package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	public void createEmp(Employee emp) {
		// validation code 
		empDao.insertEmployee(emp);
	}

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empDao.getEmployees();
	}
}
