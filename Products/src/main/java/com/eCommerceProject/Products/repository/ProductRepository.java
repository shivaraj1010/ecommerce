package com.eCommerceProject.Products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.eCommerceProject.Products.entity.Product;

@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product, String>  {
	

}
