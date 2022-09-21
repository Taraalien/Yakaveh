package com.kurdsoft.yakaveh.category;

import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.supplier.Supplier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title ;

   @ApiModelProperty(required = true,hidden = false)
    private String icon;

   @ApiModelProperty(required = true,hidden = false)
    private   Type type;



}
