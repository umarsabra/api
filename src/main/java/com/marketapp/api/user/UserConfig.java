package com.marketapp.api.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository){
        return args -> {
            User omar = new User(
                    "Omar",
                    "Sabra",
                    "omarsabra",
                    "password123"
            );
            User shehab = new User(
                    "Shehab",
                    "Ahmed",
                    "shehabahmed",
                    "password123"
            );
            userRepository.saveAll(
                    List.of(omar, shehab)
            );
        };
    }
}
