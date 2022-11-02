package com.marketapp.api.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM order o WHERE o.status = ?1 AND o.branchId = ?2", nativeQuery = true)
    List<Order> findBranchOrdersByStatus(String status, Long branchId);



}
