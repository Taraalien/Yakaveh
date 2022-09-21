package com.kurdsoft.yakaveh.supplier;

import com.kurdsoft.yakaveh.category.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISupplierService {

    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    void delete(Long id);
    List<Supplier> getAll();
    Supplier getById(Long id);
    Page<Supplier> paging(Integer page, Integer size);
    List<Supplier>getByCategoryId(Long id);
}
