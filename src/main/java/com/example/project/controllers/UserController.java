package com.example.project.controllers;

import com.example.project.models.Users;
import com.example.project.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
puclic class UserController {

    private final userService UserService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Users getUsers(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Users getUsers(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping
    public Users getUsers(@PathVariable String surname) {
        return userService.getBySurname(surname);
    }

    @GetMapping
    public Users getUsers(@PathVariable String mail) {
        return userService.getByMail(mail);
    }


}
