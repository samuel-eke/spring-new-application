package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends JpaRepository<Addresses, Long> {
}
