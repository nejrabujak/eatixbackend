package com.example.eatix.services;

import com.example.eatix.models.Product;
import com.example.eatix.models.Store;
import com.example.eatix.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {

        this.storeRepository = storeRepository;
   }

    public List<Store> getStores() {

        return storeRepository.findAll();
    }

    public Store getById(long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if(storeOptional.isPresent()) {
            return storeOptional.get();
        }

        throw new RuntimeException("Store with id:" + id + " does not exist!");
    }

    public Store create(Store store) {

        return storeRepository.save(store);
    }

    public void delete(long id) {
        storeRepository.deleteById(id);
    }
}