package com.ordermgmt.service.model;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "orderitems", url = "http://localhost:8973/")
public interface ItemClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/orderitems")
	List<Item> getOrderItems();
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/orderitems/{productCode}", consumes = "application/json")
	Item save(@PathVariable("productCode") Long productCode, Item item);
}
