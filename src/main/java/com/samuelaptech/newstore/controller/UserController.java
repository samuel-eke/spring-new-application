package com.samuelaptech.newstore.controller;

import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

}
