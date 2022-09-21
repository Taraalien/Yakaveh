package com.kurdsoft.yakaveh.supplier;

import com.kurdsoft.yakaveh.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRep extends PagingAndSortingRepository<Supplier,Long> {

    List<Supplier>findAllByCategory_Id(Long id);
    List<Supplier>findAllByCategory(Category category);

    Page<Supplier> findAll(Pageable pageable);
}
