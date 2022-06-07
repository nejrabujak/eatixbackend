package com.example.eatix.services;

import com.example.eatix.models.Store;
import com.example.eatix.models.User;
import com.example.eatix.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }

        throw new RuntimeException("User with id:" + id + " does not exist!");
    }

    public User create(User user) {

        return userRepository.save(user);
    }

    public User findById(long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }
        return null;
    }

    public void delete(long id) {
        User user = findById(id);
        userRepository.delete(user);
    }


}
