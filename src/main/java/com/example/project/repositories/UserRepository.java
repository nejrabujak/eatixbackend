package com.example.project.repositories;
import com.example.project.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Item, Long> {

}
