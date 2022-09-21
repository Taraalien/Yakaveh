package com.kurdsoft.yakaveh.supplier_category;

import com.kurdsoft.yakaveh.common.base.BaseDTO;
import com.kurdsoft.yakaveh.supplier.Supplier;
import com.kurdsoft.yakaveh.supplier.SupplierDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SupplierCatDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private List<SupplierDTO> supplierDTOList;
}
