package com.marketapp.api.category;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {

    CommandLineRunner commandLineRunnerCategory(
            CategoryRepository categoryRepository
    ){
        return args -> {
            Category beverages = new Category("Beverages");
            Category dairyAndEggs = new Category("Dairy and Eggs");
            Category bakeryAndBread  = new Category("Bakery and Bread");
            categoryRepository.saveAll(List.of(beverages, dairyAndEggs, bakeryAndBread));
        };
    }
}
