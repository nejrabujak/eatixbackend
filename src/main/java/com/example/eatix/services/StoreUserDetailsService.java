package com.example.eatix.services;

import com.example.eatix.models.SimpleStore;
import com.example.eatix.models.entities.StoreEntity;
import com.example.eatix.repositories.StoreRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class StoreUserDetailsService implements UserDetailsService {

    private final StoreRepository storeRepository;

    public StoreUserDetailsService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StoreEntity store = getFullUserByEmail(email);

        return new org.springframework.security.core.userdetails.User(store.getUsername(),
                store.getPassword(), Collections.emptyList());
    }

    public SimpleStore getUserByEmail(String email) {
        getFullUserByEmail(email); // user exists?
        return new SimpleStore(email);
    }


    private StoreEntity getFullUserByEmail(String email) {
        return storeRepository.findFirstByEmail(email);
    }
}