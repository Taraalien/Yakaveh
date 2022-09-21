package com.kurdsoft.yakaveh.supplier_category;


import com.kurdsoft.yakaveh.supplier.Supplier;
import com.kurdsoft.yakaveh.supplier.SupplierDTO;
import com.kurdsoft.yakaveh.supplier.SupplierMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierMapper.class})
public interface SupplierCatMapper {

    SupplierCat toSupplierCat(SupplierCatDTO supplierCatDTO);
    SupplierCatDTO toSupplierCatDto(SupplierCat supplierCat);

    List<SupplierCat> toSupplierCatList(List<SupplierCatDTO> supplierCatDTOList);
    List<SupplierCatDTO> toSupplierCatDtos(List<SupplierCat>  supplierCats);
}
