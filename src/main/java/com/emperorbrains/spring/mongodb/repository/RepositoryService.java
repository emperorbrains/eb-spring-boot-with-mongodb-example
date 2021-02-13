package com.emperorbrains.spring.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @author RajuKhunt
 * 
 */

@Data
@Service
@Configuration
public class RepositoryService {

	@Autowired
	private ProductRepository noteRepository;

}