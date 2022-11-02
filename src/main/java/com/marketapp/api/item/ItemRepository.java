package com.marketapp.api.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemByBranchId(Long id);
    List<Item> findItemByStoreId(Long id);
    List<Item> findItemByBarcode(Integer barcode);

}
