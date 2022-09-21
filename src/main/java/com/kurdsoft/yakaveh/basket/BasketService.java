package com.kurdsoft.yakaveh.basket;


import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketService implements IBasketService{
    private final BasketRep rep;

    @Override
    public Basket save(Basket basket) {
        return rep.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket lastItem=getById(basket.getId());
        lastItem.setCount(basket.getCount());
        return rep.save(lastItem);
    }

    @Override
    public List<Basket> getAll() {
        return (List<Basket>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Basket getById(Long id) {
        Optional<Basket> optionalBasket=rep.findById(id);
        if(!optionalBasket.isPresent()){
            throw  new NotFound("NOt found Id.");
        }
        return optionalBasket.get();
    }

    @Override
    public Page<Basket> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
