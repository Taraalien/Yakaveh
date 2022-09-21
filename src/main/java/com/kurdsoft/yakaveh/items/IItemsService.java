package com.kurdsoft.yakaveh.items;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IItemsService {

    Items save(Items items);
    Items update(Items items);
    List<Items> getAll();
    void delete(Long id);
    Items getById(Long id);
    Page<Items>paging(Integer page,Integer size);
    List<Items>getBySupplierCatId(Long id);
    List<Items>getByBasketId(Long id);



}
