package com.emperorbrains.spring.mongodb.service.impl;

import javax.validation.Valid;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emperorbrains.spring.mongodb.persistence.Product;
import com.emperorbrains.spring.mongodb.persistence.dto.GenericRes;
import com.emperorbrains.spring.mongodb.service.IProductService;
import com.emperorbrains.spring.mongodb.utils.EmperorBrainsService;
import com.emperorbrains.spring.mongodb.utils.ResponseUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author RajuKhunt
 *
 */

@Slf4j
@Service
public class ProductServiceImpl extends EmperorBrainsService implements IProductService {

	@Override
	public ResponseEntity<?> getProductById() {
		return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getProductRepository().findAll()),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProductById(String productId) {
		try {
			log.info("PocServiceImpl findById :- {}", productId);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(checkProductByIdExting(productId)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> createProduct(Product product) {
		try {
			log.info("data : - {}", product.toString());
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getProductRepository().save(product)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> updateProduct(String productId, @Valid Product productDetails) {
		try {
			Product product = checkProductByIdExting(productId);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getProductRepository().save(productDetails)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public ResponseEntity<?> deleteProduct(String productId) {
		try {
			Product product = checkProductByIdExting(productId);
			repoServ.getProductRepository().delete(product);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success("Product Deleted"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	public Product checkProductByIdExting(String productId) throws Exception {
		return repoServ.getProductRepository().findById(productId).orElseThrow(() -> new Exception("Product Id Not Found"));
	}

	@Override
	public ResponseEntity<?> searchProduct(String search) {
		try {
			TextCriteria criteria = TextCriteria.forDefaultLanguage()
					  .matchingAny(search);
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.success(repoServ.getProductRepository().findAllBy(criteria)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericRes<?>>(ResponseUtils.error(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
}
