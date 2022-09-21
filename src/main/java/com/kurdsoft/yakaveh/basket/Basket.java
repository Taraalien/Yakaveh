package com.kurdsoft.yakaveh.basket;

import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.finalbasket.FinalBasket;
import com.kurdsoft.yakaveh.items.Items;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Audited
@Table(name = "tbl_basket")
public class Basket extends BaseEntity {
    @NotNull
    @Column(name = "count")
    private Integer count;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket",cascade = CascadeType.ALL)
    private List<Items> items;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket",cascade = CascadeType.ALL)
    private List<FinalBasket> basketList;

}