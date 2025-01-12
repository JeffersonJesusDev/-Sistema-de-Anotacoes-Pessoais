package com.jjdev.Sistema.de.Anotacoes.Pessoais.controllers;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.DTO.UserDTO;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTO = users.stream()
                .map(UserDTO::new)
                .toList();
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody User user){
        userService.save(user);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User obj, @PathVariable Long id){
        obj = userService.updateUser(id, obj);
        UserDTO userDTO = new UserDTO(obj);
        return ResponseEntity.ok().body(userDTO);
    }
}
