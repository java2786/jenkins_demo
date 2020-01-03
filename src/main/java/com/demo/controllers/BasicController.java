package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

	@GetMapping("/greet")
	@ResponseBody
	public String greetUser() {
		String msg = "Welcome User";
		System.out.println(msg);
		return msg;
	}

	@GetMapping("/greet/{name}")
	@ResponseBody
	public String greetUser2(@PathVariable String name) {
		String msg = "Welcome "+name;
		System.out.println(msg);
		return msg;
	}
//}
