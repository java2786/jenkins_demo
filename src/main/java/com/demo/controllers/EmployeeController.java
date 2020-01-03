package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.model.ExceptionResponse;
import com.demo.services.EmployeeService;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	List<Employee> emps = new ArrayList<Employee>();
	private static int availableId = 1;
	public EmployeeController() {
		emps.add(new Employee(availableId++, "Arun", 34, "Delhi"));
		emps.add(new Employee(availableId++, "Subodh", 21, "Tokyo"));
		emps.add(new Employee(availableId++, "Vinod", 24, "Pune"));
		emps.add(new Employee(availableId++, "Jyoti", 29, "Delhi"));
	}

	@GetMapping(value="/", 
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
				})
//	@ResponseBody
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@PostMapping(value="/", produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
//	@ResponseBody
	public Employee createItem(@RequestBody Employee emp) throws RuntimeException {
		emp.setId(availableId++);
		if(emp.getAge() < 18) {
			throw new RuntimeException("Invalid age error");
		}
//		emps.add(emp);
		empService.createEmp(emp);
		System.out.println(emp);
		return emp;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(HttpServletRequest req, Exception ex){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), req.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(ArithmeticException.class)
//	public ResponseEntity<ExceptionResponse> arithmeticExceptionHandler(HttpServletRequest req, Exception ex){
//		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), req.getRequestURI());
//		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
//	}
	
	
}
