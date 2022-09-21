package com.kurdsoft.yakaveh.basket;


import com.kurdsoft.yakaveh.category.Category;
import com.kurdsoft.yakaveh.category.CategoryDTO;
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
@RequestMapping("/basket/")
public class BasketController {
    private final IBasketService service;
    private BasketMapper basketMapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody BasketDTO basketDTO){
        Basket basket=basketMapper.toBasket(basketDTO);
        service.save(basket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody BasketDTO basketDTO){
        Basket basket=basketMapper.toBasket(basketDTO);
        service.update(basket);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<BasketDTO> getById(@PathVariable Long id) {
        Basket basket = service.getById(id);
        BasketDTO dto = basketMapper.toBasketDto(basket);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<BasketDTO>> getAll(){
        List<Basket>baskets=service.getAll();
        List<BasketDTO>basketDTOS=basketMapper.toBasketDtos(baskets);
        return ResponseEntity.ok(basketDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<BasketDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Basket> baskets=service.paging(page,size);
        int totalPage=baskets.getTotalPages();
        List<Basket> data=baskets.getContent();
        List<BasketDTO> basketDTOS=basketMapper.toBasketDtos(data);
        PagingData<BasketDTO> pagingData=new PagingData<>(totalPage,page,basketDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
