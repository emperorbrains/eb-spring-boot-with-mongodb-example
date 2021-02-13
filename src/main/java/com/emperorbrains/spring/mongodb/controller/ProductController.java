package com.emperorbrains.spring.mongodb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emperorbrains.spring.mongodb.persistence.Product;
import com.emperorbrains.spring.mongodb.service.IProductService;

/**
 * @author RajuKhunt Created by RajuKhunt on 10-Feb-2021
 */

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/")
	public ResponseEntity<?> getAllProducts() {
		return productService.getProductById();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(value = "id") String productId) {
		return productService.getProductById(productId);
	}

	@PostMapping("/")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(value = "id") String productId, @Valid @RequestBody Product productDetails) {
		return productService.updateProduct(productId, productDetails);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") String productId) {
		return productService.deleteProduct(productId);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchProduct(@RequestParam(value = "search") String search) {
		System.out.println(search);
		return productService.searchProduct(search);
	}
}
