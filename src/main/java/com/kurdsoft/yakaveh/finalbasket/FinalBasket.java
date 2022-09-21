package com.kurdsoft.yakaveh.finalbasket;


import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Audited
@Table(name = "tbl_finlbskt")
@Data
public class FinalBasket extends BaseEntity {
    @NotNull
    @Column(name = "paid_price")
    private Double paidPrice;

    @NotNull
    @Column(name = "finalization")
    private Boolean finalization;

    @ManyToOne
    @JoinColumn(name="id_address")
    private Address address;

    @ManyToOne
    @JoinColumn(name="id_supplier")
    private Supplier supplier;


    @ManyToOne
    @JoinColumn(name = "id_basket")
    private Basket basket;




}
