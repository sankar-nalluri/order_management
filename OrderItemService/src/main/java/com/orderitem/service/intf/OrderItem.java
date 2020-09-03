package com.orderitem.service.intf;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.service.model.Item;

@RestController
@FeignClient(name="order-item", url = "http://localhost:8863")
public interface OrderItem {
	
	@RequestMapping(method = RequestMethod.GET, value = "/items")
	List<Item> getOrderItems();

	@RequestMapping(method = RequestMethod.POST, value = "/items/{itemId}", consumes = "application/json")
	Item save(@PathVariable("itemId") Long itemId, Item item);
}
