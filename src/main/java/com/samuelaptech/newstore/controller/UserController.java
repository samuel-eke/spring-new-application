package com.samuelaptech.newstore.controller;

import com.samuelaptech.newstore.dto.ChangePasswordRequestDTO;
import com.samuelaptech.newstore.dto.RegisterUserRequestDTO;
import com.samuelaptech.newstore.dto.UpdateUserDTO;
import com.samuelaptech.newstore.dto.UserDTO;
import com.samuelaptech.newstore.mappers.UserMapping;
import com.samuelaptech.newstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody RegisterUserRequestDTO registerUserRequest,
                                              UriComponentsBuilder theUriBuilder
                                              ) {
        var userRequest = userMapping.toEntity(registerUserRequest);
        userRepository.save(userRequest);
        var userDTO = userMapping.userToUserDTO(userRequest);
        var uri = theUriBuilder.path("/users/{uid}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserDTO requestUpdate,
                                              @PathVariable long uid) {
       var aUser = userRepository.findById(uid).orElse(null);
        if (aUser == null) {
            return  ResponseEntity.notFound().build();
        } else {
            userMapping.updateUser(requestUpdate, aUser);
            userRepository.save(aUser);
            return ResponseEntity.ok(userMapping.userToUserDTO(aUser));
        }
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable long uid) {
        var user = userRepository.findById(uid).orElse(null);
        if (user == null) {
            return  ResponseEntity.notFound().build();
        }

        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{uid}/change-password")
    public ResponseEntity<Void> changeUserPassword(@PathVariable long uid, @RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
        var user = userRepository.findById(uid).orElse(null);
        if (user == null) {
            return  ResponseEntity.notFound().build();
        }
        if(!user.getPassword().equals(changePasswordRequestDTO.getOldPassword())) {
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        user.setPassword(changePasswordRequestDTO.getNewPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}