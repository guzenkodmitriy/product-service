package com.guzenko.springbootmicroservices.productservice.repository;

import com.guzenko.springbootmicroservices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
