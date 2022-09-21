package com.kurdsoft.yakaveh.supplier;


import com.kurdsoft.yakaveh.category.Category;
import com.kurdsoft.yakaveh.category.CategoryDTO;
import com.kurdsoft.yakaveh.common.PagingData;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import com.kurdsoft.yakaveh.supplier_category.SupplierCatDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier/")
@AllArgsConstructor
public class SupplierController {
    private final ISupplierService service;
    private SupplierMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier=mapper.toSupplier(supplierDTO);
        service.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier=mapper.toSupplier(supplierDTO);
        service.update(supplier);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierDTO> getById(@PathVariable Long id) {
        Supplier supplier = service.getById(id);
        SupplierDTO dto = mapper.toSupplierDto(supplier);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<SupplierDTO>> getAll(){
        List<Supplier>suppliers=service.getAll();
        List<SupplierDTO>supplierDTOList=mapper.toSupplierDtos(suppliers);
        return ResponseEntity.ok(supplierDTOList);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<SupplierDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Supplier> suppliers=service.paging(page,size);
        int totalPage=suppliers.getTotalPages();
        List<Supplier> data=suppliers.getContent();
        List<SupplierDTO> supplierDTOList=mapper.toSupplierDtos(data);
        PagingData<SupplierDTO> pagingData=new PagingData<>(totalPage,page,supplierDTOList);
        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/v1/get-all-by-category-id/{category_id}")
    public ResponseEntity<List<SupplierDTO>> getAllByCategoryId(@PathVariable Long id){
        List<Supplier>suppliers=service.getByCategoryId(id);
        List<SupplierDTO> supplierDTOS=mapper.toSupplierDtos(suppliers);
        return ResponseEntity.ok(supplierDTOS);
    }

}
