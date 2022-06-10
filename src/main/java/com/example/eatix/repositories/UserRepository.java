package com.example.eatix.repositories;

import com.example.eatix.models.User;
import com.example.eatix.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    UserEntity findFirstByEmail(String email);
}
