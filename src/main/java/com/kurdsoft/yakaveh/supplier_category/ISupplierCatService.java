package com.kurdsoft.yakaveh.supplier_category;


import org.springframework.data.domain.Page;

import java.util.List;

public interface ISupplierCatService {

    SupplierCat save(SupplierCat supplierCat);
    SupplierCat update(SupplierCat supplierCat);
    void delete(Long id);
    List<SupplierCat> getAll();
    SupplierCat getById(Long id);
    Page<SupplierCat> paging(Integer page, Integer size);
    List<SupplierCat>getBySupplierId(Long id);
}
