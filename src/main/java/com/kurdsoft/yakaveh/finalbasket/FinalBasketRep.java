package com.kurdsoft.yakaveh.finalbasket;

import com.kurdsoft.yakaveh.items.Items;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalBasketRep extends PagingAndSortingRepository<FinalBasket,Long> {

    List<FinalBasket> findAllBySupplier_Id(Long id);
    List<FinalBasket> findAllByAddress_Id(Long id);
    List<FinalBasket> findAllByBasket_Id(Long id);
    Page<FinalBasket> findAll(Pageable pageable);

    
    //@Query(value="SELECT FinalBasket.paidPrice * Basket.count ")

    
}
