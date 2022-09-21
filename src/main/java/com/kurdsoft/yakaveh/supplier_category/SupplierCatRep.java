package com.kurdsoft.yakaveh.supplier_category;


import com.kurdsoft.yakaveh.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierCatRep extends PagingAndSortingRepository<SupplierCat,Long> {

   // List<SupplierCat>findAllBySupplier_Id(Long id);
    List<SupplierCat>findAllBySupplier(Supplier supplier);
    Page<SupplierCat> findAll(Pageable pageable);
}
