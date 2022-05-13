package com.example.eatix.repositories;

import com.example.eatix.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long> {

}