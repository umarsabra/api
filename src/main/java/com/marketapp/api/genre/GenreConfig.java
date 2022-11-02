package com.marketapp.api.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class GenreConfig {

    CommandLineRunner commandLineRunnerGenre(
            GenreRepository genreRepository
    ){
        return args -> {

        };
    }
}
