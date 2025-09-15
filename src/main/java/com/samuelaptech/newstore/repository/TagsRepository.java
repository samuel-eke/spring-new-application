package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Tags;
import org.springframework.data.repository.CrudRepository;

public interface TagsRepository extends CrudRepository<Tags, Long> {
}