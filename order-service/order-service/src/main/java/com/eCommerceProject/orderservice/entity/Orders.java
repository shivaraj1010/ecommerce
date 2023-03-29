package com.eCommerceProject.orderservice.entity;

import com.eCommerceProject.Products.entity.Product;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orderId;
	private Map<String,Integer> items;
	private Integer value;
	private String customerId;
	  @CreatedDate
	    private LocalDateTime createdAt ;

	    @LastModifiedDate
	    private LocalDateTime updatedAt;
	    
	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    @JoinColumn(name = "productId")
	    private Product product;
	    
	    
	    
		public Orders() {
		}



		public Orders(String orderId, Map<String, Integer> items, Integer value, String customerId,
				LocalDateTime createdAt, LocalDateTime updatedAt) {
			this.orderId = orderId;
			this.items = items;
			this.value = value;
			this.customerId = customerId;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}



		public String getOrderId() {
			return orderId;
		}



		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}



		public Map<String, Integer> getItems() {
			return items;
		}



		public void setItems(Map<String, Integer> items) {
			this.items = items;
		}



		public Integer getValue() {
			return value;
		}



		public void setValue(Integer value) {
			this.value = value;
		}



		public String getCustomerId() {
			return customerId;
		}



		public void setCustomerId(String customerId) {
			this.customerId = customerId;
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



		public Product getProduct() {
			return product;
		}



		public void setProduct(Product product) {
			this.product = product;
		}



		public void setItems(String productId, Integer quantity) {
			// TODO Auto-generated method stub
			
		}
	    
	    
	    
}
