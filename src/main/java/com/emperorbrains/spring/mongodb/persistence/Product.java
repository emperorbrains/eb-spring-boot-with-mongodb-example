package com.emperorbrains.spring.mongodb.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RajuKhunt
 * 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Product {

	@Id
	private String productId;
	
	private String name;
}
