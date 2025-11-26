package com.samuelaptech.newstore.controller;

import com.samuelaptech.newstore.dto.UserDTO;
import com.samuelaptech.newstore.entities.User;
import com.samuelaptech.newstore.mappers.UserMapping;
import com.samuelaptech.newstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapping userMapping;
    

    @GetMapping()
    public Iterable<UserDTO> getUsers(@RequestParam(required = false, defaultValue = "") String sortUser) {

        if (!Set.of("name", "email" ).contains(sortUser)) {
            sortUser = "name";
        }
        return userRepository.findAll(Sort.by(sortUser))
                .stream()
                .map(userMapping::userToUserDTO)
                .toList();
//                .stream()
//                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
//                .toList();   // this is the manual method of mapping objects
    }

    @GetMapping("/{uid}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long uid) {
            var user = userRepository.findById(uid).orElse(null);

            if (user == null) {
                return  ResponseEntity.notFound().build();
            }
//            return ResponseEntity.ok(user);
        return ResponseEntity.ok(userMapping.userToUserDTO(user));

    }

}