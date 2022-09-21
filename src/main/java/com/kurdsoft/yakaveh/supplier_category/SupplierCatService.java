package com.kurdsoft.yakaveh.supplier_category;


import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import com.kurdsoft.yakaveh.supplier.ISupplierService;
import com.kurdsoft.yakaveh.supplier.Supplier;
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
public class SupplierCatService implements ISupplierCatService{
    private final SupplierCatRep rep;
    private final ISupplierService service;
    @Override
    public SupplierCat save(SupplierCat supplierCat) {
        Long supplierId=supplierCat.getSupplier().getId();
        Supplier supplier=service.getById(supplierId);
        supplierCat.setSupplier(supplier);
        return rep.save(supplierCat);
    }

    @Override
    public SupplierCat update(SupplierCat supplierCat) {
        SupplierCat lastItem=getById(supplierCat.getId());
        lastItem.setTitle(supplierCat.getTitle());
        Long supplierId=supplierCat.getSupplier().getId();
        Supplier supplier=service.getById(supplierId);
        lastItem.setSupplier(supplier);
        return rep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        Optional<SupplierCat> supplierCatOptional=rep.findById(id);
        if(!supplierCatOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        rep.deleteById(id);
    }

    @Override
    public List<SupplierCat> getAll() {
        return (List<SupplierCat>) rep.findAll();
    }

    @Override
    public SupplierCat getById(Long id) {
        Optional<SupplierCat> supplierCatOptional=rep.findById(id);
        if(!supplierCatOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        return  supplierCatOptional.get();
    }

    @Override
    public Page<SupplierCat> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<SupplierCat> getBySupplierId(Long id) {
        Supplier supplier=service.getById(id);
        List<SupplierCat> supplierCats=rep.findAllBySupplier(supplier);
        return supplierCats;
    }
}
