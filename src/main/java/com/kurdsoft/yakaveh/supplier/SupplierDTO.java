package com.kurdsoft.yakaveh.supplier;

import com.kurdsoft.yakaveh.category.CategoryDTO;
import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.common.base.LocationDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierDTO extends BaseDTO {

    @ApiModelProperty(required =true,hidden = false)
    private String title;

    @ApiModelProperty(required =true,hidden = false)
    private String description;

    @ApiModelProperty(required =true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required =true,hidden = false)
    private List<CategoryDTO> categoryt;
}
