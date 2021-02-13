package com.emperorbrains.spring.mongodb.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.emperorbrains.spring.mongodb.persistence.Product;

/**
 * @author RajuKhunt
 *
 */

public interface IProductService {

	/**
	 * @return Products
	 */
	public ResponseEntity<?> getProductById();

	/**
	 * @param productId
	 * @return Product
	 */
	public ResponseEntity<?> getProductById(String productId);

	/**
	 * @param product
	 * @return
	 */
	public ResponseEntity<?> createProduct(Product product);

	/**
	 * @param productId
	 * @param productDetails
	 * @return
	 */
	public ResponseEntity<?> updateProduct(String productId, @Valid Product productDetails);

	/**
	 * @param productId
	 * @return
	 */
	public ResponseEntity<?> deleteProduct(String productId);

	public ResponseEntity<?> searchProduct(String search);

}
