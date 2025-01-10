package com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
