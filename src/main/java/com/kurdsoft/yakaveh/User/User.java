package com.kurdsoft.yakaveh.User;


import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.common.base.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_user")
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "family")
    private String family;


    @NotNull
    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> address;
}
