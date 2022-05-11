package com.example.project.services;

import com.example.project.models.Store;
import com.example.project.repositories.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    private final List<Store> resultList;

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
        resultList = new ArrayList<>();
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

    public Store create(Store model) {
        return storeRepository.save(model);
    }

    public Store update(Store model, long id) {
        return null;
    }

    public void delete(long id) {

    }
}