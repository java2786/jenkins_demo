package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Item;

@Controller
@RequestMapping("/items2")
public class ItemController2 {

	List<Item> items = new ArrayList<Item>();
	private static int availableId = 1;
	public ItemController2() {
		items.add(new Item(availableId++, "Mobile", 14999.9, "It is android mobile"));
		items.add(new Item(availableId++, "Laptop", 36999, "It is laptop"));
	}
	// get all items
	
	@GetMapping("/")
	@ResponseBody
	public List<Item> getItems(){
		return items;
	}
	
	
	// get item by id
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Item> getItemById(@PathVariable int id) {
		System.out.println(items);
		System.out.println("Id is "+id);
		Item foundItem = null;
		for(Item item:items) {
			if(item.getId() == id) {
				foundItem = item;
			}
		}
		System.out.println("found item : "+foundItem);
		
		if(foundItem==null) {
			return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
		} else {			
			return new ResponseEntity<Item>(foundItem, HttpStatus.OK);
		}
		
	}
	
	// create new item
	@PostMapping("/")
	@ResponseBody
	public ResponseEntity<Item> createItem(@RequestBody Item item) {
		System.out.println(item);
		
		boolean isDuplicate = false;
		if(isDuplicate) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.header("message", "you already have account")
					.build();
							
		} else {
			item.setId(availableId++);
			items.add(item);
//			return new ResponseEntity<Item>(item, HttpStatus.OK);
//			return new ResponseEntity<Item>(HttpStatus.CREATED);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(item);
		}
	}
	
	
}
