package com.samuelaptech.newstore.controller;

import com.samuelaptech.newstore.dto.UserDTO;
import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.mappers.UserMapping;
import com.samuelaptech.newstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapping userMapping;
    

    @GetMapping("/users")
    public Iterable<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapping::userToUserDTO)
                .toList();
//                .stream()
//                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
//                .toList();   // this is the manual method of mapping objects
    }

    @GetMapping("/users/{uid}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long uid) {
            var user = userRepository.findById(uid).orElse(null);

            if (user == null) {
                return  ResponseEntity.notFound().build();
            }
//            return ResponseEntity.ok(user);
        return ResponseEntity.ok(userMapping.userToUserDTO(user));

    }

}