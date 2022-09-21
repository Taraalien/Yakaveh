package com.kurdsoft.yakaveh.items;

import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.supplier.Supplier;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRep extends PagingAndSortingRepository<Items,Long> {

    List<Items>findAllBySupplierCatId(SupplierCat supplierCat);
    List<Items>findAllByBasketId(Basket basket);

    Page<Items> findAll(Pageable pageable);

}
