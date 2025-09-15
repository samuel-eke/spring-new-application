package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}