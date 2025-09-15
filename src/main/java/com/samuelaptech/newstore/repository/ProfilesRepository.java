package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Profiles;
import org.springframework.data.repository.CrudRepository;

public interface ProfilesRepository extends CrudRepository<Profiles, Long> {
}