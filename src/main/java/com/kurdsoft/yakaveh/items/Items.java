package com.kurdsoft.yakaveh.items;


import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_items")
@Audited
@Data
public class Items extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private Integer title;

    @NotNull
    @Column(name = "description")
    private Integer description;

    @NotNull
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name ="suppliercat_id")
    private SupplierCat supplierCat;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
}
