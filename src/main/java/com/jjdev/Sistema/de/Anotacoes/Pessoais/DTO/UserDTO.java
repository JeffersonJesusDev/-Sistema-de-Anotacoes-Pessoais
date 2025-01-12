package com.jjdev.Sistema.de.Anotacoes.Pessoais.DTO;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;

public record UserDTO(Long id, String name, String email) {

    public UserDTO(User user){
        this (user.getId(), user.getName(), user.getEmail());
    }

}
