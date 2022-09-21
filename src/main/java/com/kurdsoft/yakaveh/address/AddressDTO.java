package com.kurdsoft.yakaveh.address;

import com.kurdsoft.yakaveh.User.User;
import com.kurdsoft.yakaveh.User.UserDTO;
import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.common.base.LocationDTO;
import com.kurdsoft.yakaveh.finalbasket.FinalBasket;
import com.kurdsoft.yakaveh.finalbasket.FinalBasketDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
