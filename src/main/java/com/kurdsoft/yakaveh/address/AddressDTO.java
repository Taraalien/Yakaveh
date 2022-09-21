package com.kurdsoft.yakaveh.address;

import com.kurdsoft.yakaveh.user.UserDTO;
import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.common.base.LocationDTO;
import com.kurdsoft.yakaveh.finalbasket.FinalBasketDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddressDTO extends BaseDTO {

   @ApiModelProperty(required = true,hidden = false)
    private Integer unit;

    @ApiModelProperty(required = true,hidden = false)
    private Integer No;

    @ApiModelProperty(required = true,hidden = false)
    private Integer phone;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> users;

    @ApiModelProperty(required = true,hidden = false)
    private List<FinalBasketDTO> finalBasketDTOS;


}
