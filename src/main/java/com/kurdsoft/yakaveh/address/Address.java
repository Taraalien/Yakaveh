package com.kurdsoft.yakaveh.address;


import com.kurdsoft.yakaveh.User.User;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.finalbasket.FinalBasket;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Audited
@Table(name = "tbl_address")
public class Address extends BaseEntity {

    @NotNull
    @Column(name = "unit")
    private Integer unit;

    @NotNull
    @Column(name = "No")
    private Integer No;



    @NotNull
    @Column(name = "address")
    private Point<G2D> location;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "address",cascade = CascadeType.ALL)
    private List<FinalBasket> basketList;

}
