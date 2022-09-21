package com.kurdsoft.yakaveh.category;


import com.kurdsoft.yakaveh.common.base.BaseEntity;
import com.kurdsoft.yakaveh.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_category")
@Audited
public class Category  extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;


    @NotNull
    @Column(name = "icon")
    private String icon;

    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private   Type type;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.ALL)
    private List<Supplier> supplier;
}
