package com.example.eatix.controllers;

import com.example.eatix.models.Store;
import com.example.eatix.services.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")

public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @CrossOrigin
    @GetMapping
    public List<Store> getStores() {

        return storeService.getStores();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Store getStore(@PathVariable long id) {
        return storeService.getById(id);
    }

    @CrossOrigin
    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.create(store);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        storeService.delete(id);
    }
}
