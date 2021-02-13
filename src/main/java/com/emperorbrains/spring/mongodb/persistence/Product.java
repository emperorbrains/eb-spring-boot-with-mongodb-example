package com.emperorbrains.spring.mongodb.persistence;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

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
		
	@NotNull
    @Size(min=1, max= 20, message="Category should have atleast 20 characters")
	@TextIndexed
	private String category; 
	
	@NotNull
    @Size(min=1, max= 20, message="Product Category should have atleast 20 characters")
	@TextIndexed
	private String productCategory; 
	
	@NotNull
    @Size(min=1, max= 20, message="Brand Name should have atleast 20 characters")
	@TextIndexed
	private String brandName; 
	
	@NotNull
    @Size(min=1, max= 20, message="ProductName should have atleast 20 characters")
	@TextIndexed
	private String productName; 
	
	@NotNull
    @Size(min=1, max= 15, message="Size should have atleast 15 characters")
	@TextIndexed
	private String size; 
	
	@NotNull
    @Size(min=1, max= 15, message="Color should have atleast 15 characters")
	@TextIndexed
	private String color; 
	
	@NotNull
	// @Min(value=1, message="Price should have atleast 10 characters")
	// @Max(10)
	private int price; 
	
	@NotNull
    // @Min(value=1, message="Discount should have atleast 10 characters")
	// @Max(10)
	private int discount; 
	
	@NotNull
    @Size(min=1, max= 1000, message="Description should have atleast 1000 characters")
	@TextIndexed
	private String description; 
	
	@NotNull
    @Size(min=1, max= 15, message="Product Available should have atleast 15 characters")
	@TextIndexed
	private String productAvailable; 
	
	@NotNull
    @Size(min=1, max= 15, message="Discount Available should have atleast 15 characters")
	@TextIndexed
	private String discountAvailable;
	
	@NotNull
    @Size(min=1, max= 15, message="Size Available should have atleast 15 characters")
	@TextIndexed
	private String sizeAvailable;
	
	@NotNull
    @Size(min=1, max= 15, message="Color Available should have atleast 15 characters")
	@TextIndexed
	private String colorAvailable;
}
