package com.ordermgmt.service.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ordermgmt.service.model.Item;
import com.ordermgmt.service.model.ItemClient;

@RestController
@RequestMapping("/api/")
public class Orders {
	
	@Autowired
	private ItemClient itemClient;
	
	@GetMapping(value="/getOrderItems", produces= MediaType.APPLICATION_JSON_VALUE) 
	@HystrixCommand(fallbackMethod="defaultResponse") 
	public ResponseEntity<List<Item>> getOrderItems() {
	
		List<Item> orderItems = itemClient.getOrderItems();
		System.out.println("List of order items --> " + orderItems);
			  
		// Sending the response 
		return new ResponseEntity<List<Item>>(orderItems, HttpStatus.OK); 
	}
			  
		// When we define a fallback method, the fallback-method must match the same
		//parameters of the method where you define the Hystrix Command using the
		//hystrix-command annotation. 
			  
	public ResponseEntity<List<Item>> defaultResponse() { 
			System.out.println("You are seeing this fallback response because the underlying microservice is down.");
			List<Item> err = new ArrayList<Item>(); 
			return new ResponseEntity<List<Item>>(err, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

}
