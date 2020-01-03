package com.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;

//@Controller
@RestController
public class ProductController {
	List<Product> list = new ArrayList<Product>();
	private static int id = 1;
	
	public ProductController() {
		list.add(new Product(id++, "Mobile", new Date()));
		list.add(new Product(id++, "TV", new Date()));
		list.add(new Product(id++, "Iron", new Date()));
		list.add(new Product(id++, "Movies", new Date()));
		list.add(new Product(id++, "Shirts", new Date()));
	}
	
	@GetMapping("/demo")
//	@ResponseBody
	public String restApi() {
		System.out.println("in demo handler");
		return "hello";
	}
	
	@GetMapping(value="/products/{id}", 
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	@ResponseBody
	public Product getProduct(@PathVariable int id) {
		System.out.println("in product handler");
		Product p = null;
		for(Product product : list) {
			if(product.getId() == id) {
				p = product;
			}
		}
		return p;
	}
	
	@GetMapping(value="/products", 
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE 
					})
//	@ResponseBody
	public List<Product> getProducts() {
		System.out.println("in product handler");
		
		return list;
	}
	
	@PostMapping(value="/products", 
			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
			)
//	@ResponseBody
	public Product createProduct(@RequestBody Product p) {
		System.out.println("in product handler");
		p.setId(id++);
		list.add(p);
		return p;
	}
	
	
	

}
