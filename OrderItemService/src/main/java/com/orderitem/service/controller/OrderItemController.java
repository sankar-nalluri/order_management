package com.orderitem.service.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.service.exception.OrderItemNotFoundException;
import com.orderitem.service.model.Item;
import com.orderitem.service.repository.OrderItemRepository;

@RestController
@RequestMapping("/api/")
public class OrderItemController {
    
	@Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/orderitems")
    public List <Item> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @GetMapping("/orderitems/{productCode}")
    public ResponseEntity <Item> getOrderItemByCode(@PathVariable(value = "productCode") Long productCode)
    throws OrderItemNotFoundException {
        Item item = orderItemRepository.findById(productCode)
            .orElseThrow(() -> new OrderItemNotFoundException("Order item not found for this id :: " + productCode));
        return ResponseEntity.ok().body(item);
    }

    @PostMapping("/orderitems")
    public Item createNewItem(@RequestBody Item item) {
        return orderItemRepository.save(item);
    }

    @PutMapping("/orderitems/{productCode}")
    public ResponseEntity<Item> updateOrderItem(@PathVariable(value = "productCode") Long productCode,
        @RequestBody Item orderItem) throws OrderItemNotFoundException {
        Item item = orderItemRepository.findById(productCode)
            .orElseThrow(() -> new OrderItemNotFoundException("Item not found for this id :: " + productCode));

        item.setProduct_name(orderItem.getProduct_name());
        item.setQuantity(orderItem.getQuantity());
        final Item updatedOrderItem = orderItemRepository.save(item);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("/orderItems/{productCode}")
    public Map <String, Boolean> deleteOrderItem(@PathVariable(value = "productCode") Long productCode)
    throws OrderItemNotFoundException {
        Item item = orderItemRepository.findById(productCode)
            .orElseThrow(() -> new OrderItemNotFoundException("Item not found for this id :: " + productCode));

        orderItemRepository.delete(item);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

/*
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.orderitem.service.intf.OrderItem; import
 * com.orderitem.service.vo.Item;
 * 
 * @RestController public class OrderItemController {
 * 
 * @Autowired private OrderItem item;
 * 
 *//**
	 * Method to fetch the order items from DB via feign client (i.e. declarative
	 * approach).
	 * 
	 * @return
	 *//*
		 * @GetMapping(value="/getOrderItems", produces=
		 * MediaType.APPLICATION_JSON_VALUE) //@HystrixCommand(fallbackMethod=
		 * "defaultResponse") public ResponseEntity<List<Item>> getOrderItems() {
		 * 
		 * List<Item> orderItems = item.getOrderItems();
		 * System.out.println("List of order items --> " + orderItems);
		 * 
		 * // Sending the response return new ResponseEntity<List<Item>>(orderItems,
		 * HttpStatus.OK); }
		 * 
		 * // When we define a fallback method, the fallback-method must match the same
		 * parameters of the method where you define the Hystrix Command using the
		 * hystrix-command annotation. public ResponseEntity<String>
		 * defaultResponse(String err) { System.out.
		 * println("You are seeing this fallback response because the underlying microservice is down."
		 * ); err = "Fallback error as the microservice is down."; return new
		 * ResponseEntity<String>(err, HttpStatus.INTERNAL_SERVER_ERROR); }
		 * 
		 * }
		 */
