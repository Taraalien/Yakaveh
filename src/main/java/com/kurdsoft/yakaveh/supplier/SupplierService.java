package com.kurdsoft.yakaveh.supplier;


import com.kurdsoft.yakaveh.category.Category;
import com.kurdsoft.yakaveh.category.CategoryRep;
import com.kurdsoft.yakaveh.category.ICategoryService;
import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class SupplierService implements ISupplierService {
    private final SupplierRep supplierRep;
    private final ICategoryService service;

    @Override
    public Supplier save(Supplier supplier) {
        Long categoryId=supplier.getCategory().getId();
        Category category=service.getById(categoryId);
        supplier.setCategory(category);
        return supplierRep.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier lastItem=getById(supplier.getId());
        lastItem.setTitle(supplier.getTitle());
        lastItem.setDescription(supplier.getDescription());
        lastItem.setLocation(supplier.getLocation());
        Long categoryId=supplier.getCategory().getId();
        Category category=service.getById(categoryId);
        lastItem.setCategory(category);
        return supplierRep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        Optional<Supplier> supplierOptional=supplierRep.findById(id);
        if(!supplierOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        supplierRep.deleteById(id);
    }

    @Override
    public List<Supplier> getAll() {
        return (List<Supplier>) supplierRep.findAll();
    }

    @Override
    public Supplier getById(Long id) {
        Optional<Supplier> supplierOptional=supplierRep.findById(id);
        if(!supplierOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        return  supplierOptional.get();
    }

    @Override
    public Page<Supplier> paging(Integer page, Integer size) {
        return supplierRep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Supplier> getByCategoryId(Long id) {
        Category category=service.getById(id);
        return supplierRep.findAllByCategory(category);
    }
}
