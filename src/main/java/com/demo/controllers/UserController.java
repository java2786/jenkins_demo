package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.ExceptionResponse;
import com.demo.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

	List<User> users = new ArrayList<User>();
	private static int availableId = 1;
	public UserController() {
		users.add(new User(availableId++, "Arun", 34, "Delhi"));
		users.add(new User(availableId++, "Subodh", 21, "Tokyo"));
		users.add(new User(availableId++, "Vinod", 24, "Pune"));
		users.add(new User(availableId++, "Jyoti", 29, "Delhi"));
	}

	@GetMapping(value="/", 
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
				})
	@ResponseBody
	public List<User> getUsers(){
		return users;
	}
	
	@PostMapping(value="/", produces= {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
		},consumes= {
				MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE
			})
	@ResponseBody
	public User createItem(@RequestBody User user) throws RuntimeException {
		user.setId(availableId++);
		if(user.getAge() < 18) {
			throw new RuntimeException("Invalid age error");
		}
		users.add(user);
		System.out.println(user);
		return user;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> exceptionHandler(HttpServletRequest req, Exception ex){
		ExceptionResponse response = new ExceptionResponse(ex.getMessage(), req.getRequestURI());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	
}
