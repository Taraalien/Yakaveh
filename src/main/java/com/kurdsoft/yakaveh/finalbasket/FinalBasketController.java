package com.kurdsoft.yakaveh.finalbasket;


import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.address.AddressDTO;
import com.kurdsoft.yakaveh.common.PagingData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/finalbasket/")
public class FinalBasketController {
    private final IFinalBasketService service;
    private FinalBasketMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FinalBasketDTO dto){
        FinalBasket finalBasket=mapper.toFinalBasket(dto);
        service.save(finalBasket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody FinalBasketDTO dto){
        FinalBasket finalBasket=mapper.toFinalBasket(dto);
        service.update(finalBasket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FinalBasketDTO> getById(@PathVariable Long id) {
        FinalBasket basket= service.getById(id);
        FinalBasketDTO dto = mapper.toFinalBasketDto(basket);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<FinalBasketDTO>> getAll(){
        List<FinalBasket>finalBaskets=service.getAll();
        List<FinalBasketDTO>finalBasketDTOS=mapper.toFinalBasketDtos(finalBaskets);
        return ResponseEntity.ok(finalBasketDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<FinalBasketDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<FinalBasket> finalBaskets=service.paging(page,size);
        int totalPage=finalBaskets.getTotalPages();
        List<FinalBasket> data=finalBaskets.getContent();
        List<FinalBasketDTO> finalBasketDTOS=mapper.toFinalBasketDtos(data);
        PagingData<FinalBasketDTO> pagingData=new PagingData<>(totalPage,page,finalBasketDTOS);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-supplier-id/{supplier_id}")
    public ResponseEntity<List<FinalBasketDTO>> getAllBySupplierId(@PathVariable Long id){
        List<FinalBasket>finalBaskets=service.getBySupplierId(id);
        List<FinalBasketDTO> finalBasketDTOS=mapper.toFinalBasketDtos(finalBaskets);
        return ResponseEntity.ok(finalBasketDTOS);
    }


    @GetMapping("/v1/get-all-by-basket-id/{basket_id}")
    public ResponseEntity<List<FinalBasketDTO>> getAllByBasketId(@PathVariable Long id){
        List<FinalBasket>finalBaskets=service.getByBasketId(id);
        List<FinalBasketDTO> finalBasketDTOS=mapper.toFinalBasketDtos(finalBaskets);
        return ResponseEntity.ok(finalBasketDTOS);
    }



    @GetMapping("/v1/get-all-by-address-id/{address_id}")
    public ResponseEntity<List<FinalBasketDTO>> getAllByAddressId(@PathVariable Long id){
        List<FinalBasket>finalBaskets=service.getByAddressId(id);
        List<FinalBasketDTO> finalBasketDTOS=mapper.toFinalBasketDtos(finalBaskets);
        return ResponseEntity.ok(finalBasketDTOS);
    }
}
