package com.jjdev.Sistema.de.Anotacoes.Pessoais.services;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userData;

    public User save(User user) {
        return userData.save(user);
    }

    public List<User> findAll() {
        return userData.findAll();
    }

    public User findById(Long id) {
       Optional<User> user = userData.findById(id);
       return user.orElse(null);
    }

    public void deleteUser(Long id) {
        userData.deleteById(id);
    }

    public User updateUser(Long id, User obj) {
        User user = findById(id);
        user.setName(obj.getName());
        user.setEmail(obj.getEmail());
        user.setPassword(obj.getPassword());
        return userData.save(user);
    }


}
