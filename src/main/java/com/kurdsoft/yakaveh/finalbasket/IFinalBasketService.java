package com.kurdsoft.yakaveh.finalbasket;

import com.kurdsoft.yakaveh.items.Items;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IFinalBasketService {

    FinalBasket save(FinalBasket basket);
    FinalBasket update(FinalBasket basket);
    List<FinalBasket> getAll();
    void delete(Long id);
    FinalBasket getById(Long id);
    List<FinalBasket>getBySupplierId(Long id);
    List<FinalBasket>getByAddressId(Long id);
    List<FinalBasket>getByBasketId(Long id);
    Page<FinalBasket> paging(Integer page, Integer size);
}
