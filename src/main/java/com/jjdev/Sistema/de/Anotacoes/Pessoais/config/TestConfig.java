package com.jjdev.Sistema.de.Anotacoes.Pessoais.config;

import com.jjdev.Sistema.de.Anotacoes.Pessoais.entities.User;
import com.jjdev.Sistema.de.Anotacoes.Pessoais.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Jefferson de Jesus", "jefferson@testmail.com", "12345");
        User user2 = new User(null, "Jackson de Jesus", "jackson@testmail.com", "54321");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
