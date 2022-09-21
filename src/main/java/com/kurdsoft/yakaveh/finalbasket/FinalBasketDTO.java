package com.kurdsoft.yakaveh.finalbasket;

import com.kurdsoft.yakaveh.User.User;
import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.address.AddressDTO;
import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.basket.BasketDTO;
import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.supplier.Supplier;
import com.kurdsoft.yakaveh.supplier.SupplierDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FinalBasketDTO extends BaseDTO {
   @ApiModelProperty(required = true,hidden = false)
    private Double paidPrice;


    @ApiModelProperty(required = true,hidden = false)
    private Boolean finalization;


    @ApiModelProperty(required = true,hidden = false)
    private AddressDTO address;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;


    @ApiModelProperty(required = true,hidden = false)
    private BasketDTO basket;
}
