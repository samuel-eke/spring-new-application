package com.samuelaptech.newstore.repository;

import com.samuelaptech.newstore.entities.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
}