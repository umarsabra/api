package com.marketapp.api.orderitem;


import com.marketapp.api.branch.Branch;
import com.marketapp.api.item.Item;
import com.marketapp.api.order.Order;
import com.marketapp.api.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;

    private String status;
    private Float totalPrice;
    private Float totalCost;
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_item_item_id_fk"))
    private Long itemId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_item_order_id_fk"))
    private Long orderId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Store.class)
    @JoinColumn(name = "store_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_item_store_id_fk"))
    private Long storeId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Branch.class)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="order_item_branch_id_fk"))
    private Long branchId;

}
