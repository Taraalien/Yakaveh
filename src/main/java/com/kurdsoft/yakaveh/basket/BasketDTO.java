package com.kurdsoft.yakaveh.basket;

import com.kurdsoft.yakaveh.common.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class BasketDTO extends BaseDTO {


    @ApiModelProperty(required = true,hidden = false)
    private Integer count;


}
