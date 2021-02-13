package com.emperorbrains.spring.mongodb.repository;


import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.emperorbrains.spring.mongodb.persistence.Product;

/**
 * @author RajuKhunt
 *
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findAllBy(TextCriteria criteria);
}
