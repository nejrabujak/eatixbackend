package com.example.eatix.services;


import com.example.eatix.models.SimpleUser;
import com.example.eatix.models.entities.UserEntity;
import com.example.eatix.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegularUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public RegularUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = getFullUserByEmail(email);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByEmail(String email) {
        getFullUserByEmail(email); // user exists?
        return new SimpleUser(email);
    }


    private UserEntity getFullUserByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
}