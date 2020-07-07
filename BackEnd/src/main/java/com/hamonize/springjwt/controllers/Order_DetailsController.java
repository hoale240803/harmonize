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
import com.hamonize.springjwt.models.Order_Details;
import com.hamonize.springjwt.repository.OrderDetailsRepository;


@RestController @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("")// http://localhost:8080/employees
public class Order_DetailsController {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@GetMapping("/order_details")
	public List<Order_Details> getAllOrder_Details() {
		return orderDetailsRepository.findAll();
	}

	@GetMapping("/order_details/{id}")
	public ResponseEntity<Order_Details> getOrder_DetailsById(@PathVariable(value = "id") Long order_detailsId)
			throws ResourceNotFoundException {
		Order_Details employee = orderDetailsRepository.findById(order_detailsId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Details not found for this id  : " + order_detailsId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/order_details")
	public Order_Details createOrder_Details(@Validated @RequestBody Order_Details employee) {
		return orderDetailsRepository.save(employee);
	}

	@PutMapping("/order_details/{id}")
	public ResponseEntity<Order_Details> updateOrder_Details(@PathVariable(value = "id") Long order_detailsId,
			@Validated @RequestBody Order_Details employeeDetails) throws ResourceNotFoundException {
		Order_Details employee = orderDetailsRepository.findById(order_detailsId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Details not found for this id : " + order_detailsId));
		employee.setOrders_id(employeeDetails.getOrders_id());
		employee.setProducts_id(employeeDetails.getProducts_id());
		employee.setQuantity(employeeDetails.getQuantity());
		employee.setCurrentPrice(employeeDetails.getCurrentPrice());
		employee.setCurrentDescription(employeeDetails.getCurrentDescription());
		employee.setActives(employeeDetails.getActives());
		final Order_Details updatedOrder_Details = orderDetailsRepository.save(employee);
		return ResponseEntity.ok(updatedOrder_Details);
	}

	@DeleteMapping("/order_details/{id}")
	public Map<String, Boolean> deleteOrder_Details(@PathVariable(value = "id") Long order_detailsId)
			throws ResourceNotFoundException {
		Order_Details employee = orderDetailsRepository.findById(order_detailsId)
				.orElseThrow(() -> new ResourceNotFoundException("Order_Details not found for this id : " + order_detailsId));
		orderDetailsRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
