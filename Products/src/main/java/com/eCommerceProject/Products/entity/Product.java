package com.eCommerceProject.Products.entity;

import com.eCommerceProject.orderservice.entity.Orders;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection="productservice")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String productId;
	private String name;
	private String description;
	private Long price;
	private Long stockCount;
   
	  @CreatedDate
	    private LocalDateTime createdAt ;

	    @LastModifiedDate
	    private LocalDateTime updatedAt;

	    @Version
	    private Integer version;
	    
	    @OneToOne(mappedBy = "Product")
	    private Orders orders;
	
	public Product
	() {
		
	}

	public Product(String productId, String name, String description, Long price, Long stockCount, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockCount = stockCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getStockCount() {
		return stockCount;
	}

	public void setStockCount(Long stockCount) {
		this.stockCount = stockCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
