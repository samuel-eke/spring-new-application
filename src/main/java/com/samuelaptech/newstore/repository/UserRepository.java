package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  }