package ru.kata.spring.boot_security.demo.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataBaseInitializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataBaseInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {
        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User admin = new User("admin", "admin", "admin", "admin", Set.of(roleAdmin, roleUser));
        User user = new User("user", "user", "user", "user", Set.of(roleUser));

        userService.save(admin);
        userService.save(user);
    }
}

