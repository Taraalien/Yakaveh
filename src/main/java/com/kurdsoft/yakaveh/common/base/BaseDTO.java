package com.kurdsoft.yakaveh.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;




@Data
public class BaseDTO {
    @ApiModelProperty(required =false,hidden = true)
    private Long id;

    @ApiModelProperty(required = false,hidden = true)
    private Integer version;

    @ApiModelProperty(required = false,hidden = true)
    private Date createDate;

    @ApiModelProperty(required = false,hidden = true)
    private String createdBy;

    @ApiModelProperty(required = false,hidden = true)
    private Date lastModifiedDate;

    @ApiModelProperty(required = false,hidden = true)
    private String lastModifiedBy;
}
