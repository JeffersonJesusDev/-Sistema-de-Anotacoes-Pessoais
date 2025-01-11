package com.jjdev.Sistema.de.Anotacoes.Pessoais.controllers;

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
    public ResponseEntity<List<User>>  getUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User obj, @PathVariable Long id){
        obj = userService.updateUser(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
