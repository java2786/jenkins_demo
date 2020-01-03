package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping("/items")
public class ItemController {

	List<Item> items = new ArrayList<Item>();
	private static int availableId = 1;
	public ItemController() {
		items.add(new Item(availableId++, "Mobile", 14999.9, "It is android mobile"));
		items.add(new Item(availableId++, "Laptop", 36999, "It is laptop"));
//		items.add(new Item(availableId++, "TV", 29999.9, "It is smart tv"));
//		items.add(new Item(availableId++, "Shirt", 999.9, "It is my blue shirt"));
	}
	// get all items

	@GetMapping("/")
//	@CrossOrigin(origins = "http://localhost:5000")
	@ResponseBody
	public List<Item> getItems(){
		System.out.println("request is recieved");
		return items;
	}


	// get item by id
	@GetMapping(value="/{id}")
	@ResponseBody
	public Item getItemById(@PathVariable int id) {
		System.out.println(items);
		System.out.println("Id is "+id);
		Item foundItem = null;
		for(Item item:items) {
			if(item.getId() == id) {
				foundItem = item;
			}
		}
		System.out.println("found item : "+foundItem);
		return foundItem;
	}
	// create new item
	@PostMapping("/")
	@ResponseBody
	public Item createItem(@RequestBody Item item) {
		item.setId(availableId++);
		items.add(item);
		System.out.println(item);
		return item;
	}


	// update item
	@PutMapping("/{id}")
	@ResponseBody
	public Item updateItem(@RequestBody Item item, @PathVariable int id) {
		System.out.println("Update : "+item);
		System.out.println("Where id : "+id);
		return null;
	}

	// delete item
	@DeleteMapping("/{id}")
	@ResponseBody
	public Item removeItem(@PathVariable int id) {
		System.out.println("Remove item where id : "+id);
		return null;
	}

}
