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
import com.hamonize.springjwt.models.Products;
import com.hamonize.springjwt.repository.ProductsRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class ProductsController {

	@Autowired
	ProductsRepository productsRepository;
	
	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductId(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Products product = productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id  : " + productId));
		return ResponseEntity.ok().body(product);
	}

	@PostMapping("/products")
	public Products createProduct(@Validated @RequestBody Products product) {
		return productsRepository.save(product);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable(value = "id") Long productId,
			@Validated @RequestBody Products productRequest) throws ResourceNotFoundException {
		Products product= productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + productId));
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		product.setDescription(productRequest.getDescription());
		product.setStates(productRequest.getStates());
		product.setActives(productRequest.getActives());
		product.setImage(productRequest.getImage());
		final Products updatedProduct= productsRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Products product = productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id : " + productId));
		productsRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
