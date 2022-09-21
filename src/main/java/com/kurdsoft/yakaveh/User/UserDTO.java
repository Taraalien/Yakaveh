package com.kurdsoft.yakaveh.User;

import com.kurdsoft.yakaveh.common.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private String family;


    @ApiModelProperty(required = true,hidden = false)
    private String phone;

}
