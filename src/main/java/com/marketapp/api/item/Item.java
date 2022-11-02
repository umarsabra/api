package com.marketapp.api.item;

import com.marketapp.api.branch.Branch;
import com.marketapp.api.category.Category;
import com.marketapp.api.store.Store;
import com.marketapp.api.subcategory.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Item {
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
    private String barcode;
    private String title;
    private Float price;
    private Float totalCost;
    private Integer quantity;

    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = Category.class
    )
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "item_category_id_fk")
    )
    private Long categoryId;
    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = Subcategory.class
    )

    @JoinColumn(
            name = "subcategory_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "item_subcategory_id_fk")
    )
    private Long subcategoryId;


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Store.class)
    @JoinColumn(name = "store_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="item_store_id_fk"))
    private Long storeId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Branch.class)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="item_branch_id_fk"))
    private Long branchId;


}
