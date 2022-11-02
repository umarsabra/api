package com.marketapp.api.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getBranchItems(@PathVariable Long branchId){
        return itemService.getBranchItems(branchId);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item){
        itemService.addItem(item);
        return item;
    }
}
