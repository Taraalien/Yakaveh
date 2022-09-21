package com.kurdsoft.yakaveh.basket;

import com.kurdsoft.yakaveh.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface BasketRep extends PagingAndSortingRepository<Basket,Long> {

    Page<Basket> findAll(Pageable pageable);
}
