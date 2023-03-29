package com.eCommerceProject.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eCommerceProject.orderservice.entity.Orders;

public interface orderRepository extends MongoRepository<Orders, String> {

}
