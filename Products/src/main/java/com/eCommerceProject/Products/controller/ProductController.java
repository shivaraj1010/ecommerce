package com.eCommerceProject.Products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerceProject.Products.entity.Product;
import com.eCommerceProject.Products.repository.ProductRepository;
import com.eCommerceProject.User.entity.user;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/createProducts")
	public Product saveProducts(@RequestBody Product prodcut) {
		
		Product products=productRepository.save(prodcut);
		
		return new Product(products.getProductId(),products.getName(),products.getDescription(),
				products.getPrice(),products.getStockCount(),products.getCreatedAt(),products.getUpdatedAt());
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getProducts() {
		
		List<Product> products =productRepository.findAll();
		
		System.out.println(products);
		
		return products;
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductId(@PathVariable String productId) {
		
		Optional<Product> products =productRepository.findById(productId);
		
		System.out.println(products);
		
		return products;
	}
	
	@PutMapping(value="/products/{id}")
	public String updateProductId(@PathVariable String productId,@RequestBody Product products) {
		
		if(productId!= null) {
			boolean isIdAvailable=productRepository.existsById(productId);
			if(isIdAvailable==true) {
				Product product1=new Product(products.getProductId(),products.getName(),products.getDescription(),
						products.getPrice(),products.getStockCount(),products.getCreatedAt(),products.getUpdatedAt());
				
				Product use=productRepository.save(product1);
				
				return "sucessfull";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
	@DeleteMapping(value="/product/{id}")
	public String deleteProductId(@PathVariable String productId) {
		
		if(productId!= null) {
			boolean isIdAvailable=productRepository.existsById(productId);
			if(isIdAvailable==true) {
				
				
				productRepository.deleteById(productId);
				
				return "sucessfull deleted";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	

}
