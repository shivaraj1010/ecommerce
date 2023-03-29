package com.eCommerceProject.orderservice.controller;

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
import com.eCommerceProject.orderservice.entity.Orders;
import com.eCommerceProject.orderservice.repository.orderRepository;


@RestController
public class OrderController {
	
	@Autowired
	private orderRepository orderRepository;
	
	@PostMapping("/createOrders/{quantity}")
	public Orders saveProducts(@RequestBody Orders order,@RequestBody Product product,@PathVariable Integer Quantity) {
		
		//order.setItems(product.getProductId(),Quantity);
		Orders orders=orderRepository.save(order);
		
		return new Orders(orders.getOrderId(),orders.getItems(), orders.getCustomerId(),orders.ge tItems(product.getProductId(),3),orders.getCreatedAt(),orders.getUpdatedAt());
	}
	
	@GetMapping("/getAllCatalogs")
	public List<Catalog> getCatalogs() 
		
		List<Catalog> catalogs =orderRepository.findAll();
		
		System.out.println(catalogs);
		
		return catalogs;
	}
	
	@GetMapping("/catalogs/{id}")
	public Optional<Catalog> getCatalogId(@PathVariable String catalogId) {
		
		Optional<Catalog> catalogs =orderRepository.findById(catalogId);
		
		System.out.println(catalogs);
		
		return catalogs;
	}
	
	@PutMapping(value="/catalogs/{id}")
	public String updateCatalogId(@PathVariable String catalogId,@RequestBody Catalog catalogs) {
		
		if(catalogId!= null) {
			boolean isIdAvailable=orderRepository.existsById(catalogId);
			if(isIdAvailable==true) {
				Catalog catalog1=new Catalog(catalogs.getCatalogId(),catalogs.getName(),catalogs.getDescription(),
						catalogs.getImage(),catalogs.getCreatedAt(),catalogs.getUpdatedAt());
				
				Catalog use=orderRepository.save(catalog1);
				
				return "sucessfull";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}
	
	@DeleteMapping(value="/catalog/{id}")
	public String deleteCatalogId(@PathVariable String catalogId) {
		
		if(catalogId!= null) {
			boolean isIdAvailable=orderRepository.existsById(catalogId);
			if(isIdAvailable==true) {
				
				
				orderRepository.deleteById(catalogId);
				
				return "sucessfull deleted";
			
			}else {
				return "id is not available";
			}
			
		}
		return "enter a valid id";
			
	}

}
