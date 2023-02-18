package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User findByUsername(String username);
    User getById(Long id);
    void deleteById(Long id);
    void save(User user);
    void edit(User user);


}
