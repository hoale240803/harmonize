package com.hamonize.springjwt.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamonize.springjwt.exception.ResourceNotFoundException;
import com.hamonize.springjwt.models.Orders;
import com.hamonize.springjwt.repository.OrdersRepository;


@RestController @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("")
public class OrdersController {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	@GetMapping("/orders/{id}")
	public ResponseEntity<Orders> getOrdersId(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Orders order = ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id  : " + orderId));
		return ResponseEntity.ok().body(order);
	}

	@PostMapping("/orders")
	public Orders createOrders(@Validated @RequestBody Orders product) {
		return ordersRepository.save(product);
	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Orders> updateOrders(@PathVariable(value = "id") Long orderId,
			@Validated @RequestBody Orders orderRequest) throws ResourceNotFoundException {
		Orders order= ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id : " + orderId));
		order.setDate(orderRequest.getDate());
		order.setTotal(orderRequest.getTotal());
		order.setDescription(orderRequest.getDescription());
		order.setUsers_id(orderRequest.getUsers_id());
		order.setStates(orderRequest.getStates());
		order.setActives(orderRequest.getActives());
		final Orders updatedOrder= ordersRepository.save(order);
		return ResponseEntity.ok(updatedOrder);
	}

	@DeleteMapping("/orders/{id}")
	public Map<String, Boolean> deleteOrders(@PathVariable(value = "id") Long orderId)
			throws ResourceNotFoundException {
		Orders order= ordersRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id : " + orderId));
		ordersRepository.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
