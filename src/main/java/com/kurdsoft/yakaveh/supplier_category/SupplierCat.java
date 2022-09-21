package com.kurdsoft.yakaveh.supplier_category;


import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.items.Items;
import com.kurdsoft.yakaveh.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_suppliercat")
@Audited
public class SupplierCat extends BaseEntity {

    @NotNull
    @Column(name = "tile")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplierCat",cascade = CascadeType.ALL)
    private List<Items> items;
}
