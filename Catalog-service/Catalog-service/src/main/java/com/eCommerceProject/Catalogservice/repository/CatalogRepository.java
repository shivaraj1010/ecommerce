package com.eCommerceProject.Catalogservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eCommerceProject.Catalogservice.entity.Catalog;

public interface CatalogRepository extends MongoRepository<Catalog, String> {

}
