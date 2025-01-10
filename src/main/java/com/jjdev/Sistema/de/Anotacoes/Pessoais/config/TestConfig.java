package com.jjdev.Sistema.de.Anotacoes.Pessoais.config;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.Note;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.NotesRepository;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    private final UserRepository userRepository;
    private final NotesRepository notesRepository;

    public TestConfig(UserRepository userRepository, NotesRepository notesRepository) {
        this.userRepository = userRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Jefferson de Jesus", "jefferson@testmail.com", "12345");
        User user2 = new User(null, "Jackson de Jesus", "jackson@testmail.com", "54321");

        Note n1 = new Note(null,"Poema","Lorem ipsilum", new Date(), new Date(),"Pessoal", user1);

        Note n2 = new Note(null, "Lista de Compras", "1. Pão\n2. Leite\n3. Ovos", new Date(), new Date(), "Compras", user2);

        userRepository.saveAll(Arrays.asList(user1, user2));
        notesRepository.saveAll(Arrays.asList(n1, n2));
    }
}
