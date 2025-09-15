package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}