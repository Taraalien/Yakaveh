package com.kurdsoft.yakaveh.basket;

import com.kurdsoft.yakaveh.items.Items;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBasketService {

    Basket save(Basket basket);
    Basket update(Basket basket);
    List<Basket> getAll();
    void delete(Long id);
    Basket getById(Long id);
    Page<Basket> paging(Integer page, Integer size);
}
