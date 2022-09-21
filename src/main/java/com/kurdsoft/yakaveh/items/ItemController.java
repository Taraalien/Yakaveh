package com.kurdsoft.yakaveh.items;

import com.kurdsoft.yakaveh.common.PagingData;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import com.kurdsoft.yakaveh.supplier_category.SupplierCatDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items/")
@Data
public class ItemController {
    private final IItemsService service;
    private ItemsMapper itemsMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ItemsDTO dto){
        Items items=itemsMapper.toItems(dto);
        service.save(items);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ItemsDTO dto){
        Items items=itemsMapper.toItems(dto);
        service.update(items);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<ItemsDTO> getById(@PathVariable Long id) {
        Items items= service.getById(id);
        ItemsDTO dto = itemsMapper.toItemsDto(items);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<ItemsDTO>> getAll(){
        List<Items>items=service.getAll();
        List<ItemsDTO>itemsDTOS=itemsMapper.toItemsDtos(items);
        return ResponseEntity.ok(itemsDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<ItemsDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Items> items=service.paging(page,size);
        int totalPage=items.getTotalPages();
        List<Items> data=items.getContent();
        List<ItemsDTO> itemsDTOS=itemsMapper.toItemsDtos(data);
        PagingData<ItemsDTO> pagingData=new PagingData<>(totalPage,page,itemsDTOS);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-suppliercategory-id/{suppliercategory_id}")
    public ResponseEntity<List<ItemsDTO>> getAllBySupplierCatId(@PathVariable Long id){
        List<Items>items=service.getBySupplierCatId(id);
        List<ItemsDTO> itemsDTOS=itemsMapper.toItemsDtos(items);
        return ResponseEntity.ok(itemsDTOS);
    }

    @GetMapping("/v1/get-all-by-basket-id/{basket_id}")
    public ResponseEntity<List<ItemsDTO>> getAllByBasketId(@PathVariable Long id){
        List<Items>items=service.getByBasketId(id);
        List<ItemsDTO> itemsDTOS=itemsMapper.toItemsDtos(items);
        return ResponseEntity.ok(itemsDTOS);
    }
}


