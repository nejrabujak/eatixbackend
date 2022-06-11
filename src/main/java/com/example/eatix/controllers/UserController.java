package com.example.eatix.controllers;

import com.example.eatix.models.Product;
import com.example.eatix.models.Store;
import com.example.eatix.models.User;
import com.example.eatix.services.ProductService;
import com.example.eatix.services.StoreService;
import com.example.eatix.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping
    public List<User> getUsers() {

        return userService.getUsers();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getById(id);
    }

    @CrossOrigin
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }
}


