package com.marketapp.api.store;


import com.marketapp.api.genre.Genre;
import com.marketapp.api.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class StoreConfig {

    CommandLineRunner commandLineRunnerStore(StoreRepository storeRepository){
     return args -> {
         User omar = new User(
                 "Omar",
                 "Sabra",
                 "omarsabra",
                 "password123"
         );



         Genre grocery = new Genre("grocery");

         Store store1 = new Store(
                 "Omar's Store",
                 grocery,
                 omar
         );
         Store store2 = new Store(
                 "Omar's Store",
                 grocery,
                 omar
         );
         storeRepository.saveAll(List.of(store1, store2));
     };
    }
}
