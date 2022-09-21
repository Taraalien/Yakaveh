package com.kurdsoft.yakaveh.supplier;


import com.kurdsoft.yakaveh.category.Category;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.finalbasket.FinalBasket;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_supplier")
@Audited
public class Supplier extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<SupplierCat> supplierCat;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<FinalBasket> basketList;

}
