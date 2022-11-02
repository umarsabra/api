package com.marketapp.api.branch;


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
public class Branch {
    @Id
    @SequenceGenerator(
            name = "branch_sequence",
            sequenceName = "branch_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_sequence"
    )
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Store.class)
    @JoinColumn(name = "store_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "branch_store_id_fk"))
    private Long storeId;

}
