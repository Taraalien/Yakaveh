package com.kurdsoft.yakaveh.items;

import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.basket.IBasketService;
import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import com.kurdsoft.yakaveh.supplier_category.ISupplierCatService;
import com.kurdsoft.yakaveh.supplier_category.SupplierCat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class ItemsService implements IItemsService{
    private final ItemsRep rep;
    private final ISupplierCatService service;
    private final IBasketService basketService;
    @Override
    public Items save(Items items) {
        Long supplierCatId=items.getSupplierCat().getId();
        SupplierCat supplierCat=service.getById(supplierCatId);
        Long basketId=items.getBasket().getId();
        Basket basket=basketService.getById(basketId);
        items.setSupplierCat(supplierCat);
        items.setBasket(basket);
        return rep.save(items);
    }

    @Override
    public Items update(Items items) {
        Items lastItem=getById(items.getId());
        lastItem.setTitle(items.getTitle());
        lastItem.setDescription(items.getDescription());
        lastItem.setPrice(items.getPrice());
        Long supplierCatId=items.getSupplierCat().getId();
        SupplierCat supplierCat=service.getById(supplierCatId);
        Long basketId=items.getBasket().getId();
        Basket basket=basketService.getById(basketId);
        lastItem.setBasket(basket);
        lastItem.setSupplierCat(supplierCat);
        return rep.save(lastItem);
    }

    @Override
    public List<Items> getAll() {
        return (List<Items>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
            rep.deleteById(id);
    }

    @Override
    public Items getById(Long id) {
        Optional<Items> optionalItems=rep.findById(id);
        if(!optionalItems.isPresent()){
            throw  new NotFound("Not found Id.");
        }
        return optionalItems.get();
    }

    @Override
    public Page<Items> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Items> getBySupplierCatId(Long id) {
        SupplierCat supplierCat=service.getById(id);
        List<Items> items=rep.findAllBySupplierCatId(supplierCat);
        return items;
    }

    @Override
    public List<Items> getByBasketId(Long id) {
        Basket basket=basketService.getById(id);
        List<Items> items=rep.findAllByBasketId(basket);
        return items;
    }
}
