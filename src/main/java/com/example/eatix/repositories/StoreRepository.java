package com.example.eatix.repositories;

import com.example.eatix.models.Store;
import com.example.eatix.models.entities.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long> {

    StoreEntity findFirstByEmail(String email);

}