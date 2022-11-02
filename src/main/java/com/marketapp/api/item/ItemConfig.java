package com.marketapp.api.item;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
public class ItemConfig {
     CommandLineRunner commandLineRunnerItem(
            ItemRepository itemRepository
    ){
        return  args -> {

            Item item1 = Item.builder()
                    .barcode("622928734538")
                    .title("Pepsi 350ml")
                    .price(6F)
                    .quantity(20)
                    .totalCost(100F)
                    .categoryId(1L)
                    .subcategoryId(1L)
                    .storeId(1L)
                    .branchId(1L)
                    .build();


            Item item2 =  Item.builder()
                    .barcode("622928734568")
                    .title("Milk 500ml")
                    .price(6F)
                    .quantity(20)
                    .totalCost(100F)
                    .categoryId(2L)
                    .subcategoryId(1L)
                    .storeId(1L)
                    .branchId(1L)
                    .build();


            Item item3 =  Item.builder()
                    .barcode("622924734538")
                    .title("White Bread")
                    .price(6F)
                    .quantity(20)
                    .totalCost(100F)
                    .categoryId(3L)
                    .subcategoryId(1L)
                    .storeId(2L)
                    .branchId(1L)
                    .build();

            itemRepository.saveAll(List.of(item1, item2, item3));

        };
    }


}
