package com.emperorbrains.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.emperorbrains.spring.mongodb.persistence.Product;

/**
 * @author RajuKhunt
 *
 */

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
