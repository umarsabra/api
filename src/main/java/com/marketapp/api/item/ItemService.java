package com.marketapp.api.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getBranchItems(Long branchId){
        return itemRepository.findItemByBranchId(branchId);
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
