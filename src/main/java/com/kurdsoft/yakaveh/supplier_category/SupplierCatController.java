package com.kurdsoft.yakaveh.supplier_category;


import com.kurdsoft.yakaveh.common.PagingData;
import com.kurdsoft.yakaveh.supplier.Supplier;
import com.kurdsoft.yakaveh.supplier.SupplierDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SupplierCatController {
    private final ISupplierCatService service;
    private SupplierCatMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody SupplierCatDTO dto){
        SupplierCat supplierCat=mapper.toSupplierCat(dto);
        service.update(supplierCat);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody SupplierCatDTO dto){
        SupplierCat supplierCat=mapper.toSupplierCat(dto);
        service.save(supplierCat);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierCatDTO> getById(@PathVariable Long id) {
        SupplierCat supplierCat= service.getById(id);
        SupplierCatDTO dto = mapper.toSupplierCatDto(supplierCat);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<SupplierCatDTO>> getAll(){
        List<SupplierCat>supplierCats=service.getAll();
        List<SupplierCatDTO>supplierCatDTOS=mapper.toSupplierCatDtos(supplierCats);
        return ResponseEntity.ok(supplierCatDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<SupplierCatDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<SupplierCat> supplierCats=service.paging(page,size);
        int totalPage=supplierCats.getTotalPages();
        List<SupplierCat> data=supplierCats.getContent();
        List<SupplierCatDTO> supplierDTOList=mapper.toSupplierCatDtos(data);
        PagingData<SupplierCatDTO> pagingData=new PagingData<>(totalPage,page,supplierDTOList);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-supplier-id/{supplier_id}")
    public ResponseEntity<List<SupplierCatDTO>> getAllBySupplierId(@PathVariable Long id){
        List<SupplierCat>supplierCats=service.getBySupplierId(id);
        List<SupplierCatDTO> supplierCatDTOS=mapper.toSupplierCatDtos(supplierCats);
        return ResponseEntity.ok(supplierCatDTOS);
    }
}
