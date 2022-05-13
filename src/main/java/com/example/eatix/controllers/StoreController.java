package com.example.eatix.controllers;

import com.example.eatix.models.Store;
import com.example.eatix.services.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getItems() {
        return storeService.getStores();
    }

    @GetMapping("/{id}")
    public Store getStore(@PathVariable long id) {
        return storeService.getById(id);
    }

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.create(store);
    }

}