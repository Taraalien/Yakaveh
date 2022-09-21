package com.kurdsoft.yakaveh.items;


import com.kurdsoft.yakaveh.basket.BasketDTO;
import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import com.kurdsoft.yakaveh.supplier_category.SupplierCatDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemsDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private Integer title;

    @ApiModelProperty(required = true,hidden = false)
    private Integer description;

    @ApiModelProperty(required = true,hidden = false)
    private Double price;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierCatDTO supplierCatDTO;

    @ApiModelProperty(required = true,hidden = false)
    private BasketDTO basketDTOS;
}
