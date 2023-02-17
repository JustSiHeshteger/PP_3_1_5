package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User findByEmail(String email);
    User getById(Long id);
    void deleteById(Long id);
    void save(User user);
    void edit(User user);


}
