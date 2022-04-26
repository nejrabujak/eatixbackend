package com.example.project.services;

        import com.example.project.models.Users;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@Service
public class UserService {

    public List<Users> getUsers() {
        return itemRepository.findAll();
    }
    public User getById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }

        throw new RuntimeException("Item with id:" + id + " does not exist!");
    }

    public User update(User model, long id) {
        return null;
    }

    public void delete(long id) {

    }

    public User getByName(String name) {
        return name.get();
    }

    public User getBySurname(String surname) {
        return surname.get();
    }

    public User getByMail(String mail) {
        return mail.get();
    }
}