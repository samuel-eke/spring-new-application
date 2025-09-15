package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Addresses;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Long> {
}