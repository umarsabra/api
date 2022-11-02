package com.marketapp.api.order;


import com.marketapp.api.branch.Branch;
import com.marketapp.api.store.Store;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    private String status;
    private Float totalPrice;
    private Float totalCost;
    private LocalDate dateCreated;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Store.class)
    @JoinColumn(name = "store_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_store_id_fk"))
    private Long storeId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Branch.class)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_branch_id_fk"))
    private Long branchId;

    public Order(String status, Float totalPrice, Float totalCost, LocalDate dateCreated, Long branchId, Long storeId) {
        this.status = status;
        this.totalPrice = totalPrice;
        this.totalCost = totalCost;
        this.dateCreated = dateCreated;
        this.branchId = branchId;
        this.storeId = storeId;
    }


}
