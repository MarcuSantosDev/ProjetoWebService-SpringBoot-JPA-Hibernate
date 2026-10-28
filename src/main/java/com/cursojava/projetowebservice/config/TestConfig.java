package com.cursojava.projetowebservice.config;

import com.cursojava.projetowebservice.entities.User;
import com.cursojava.projetowebservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test") // Nome que foi colocado no application.properties
public class TestConfig implements CommandLineRunner {

    @Autowired // Solicita ao Spring a injeção automática de uma dependência gerenciada pelo contêiner (bean).
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        // SaveAll() do Spring Data JPA salva vários objetos no banco de dados em uma única chamada ao repositório.
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
