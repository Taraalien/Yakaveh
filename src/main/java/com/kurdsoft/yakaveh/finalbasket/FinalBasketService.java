package com.kurdsoft.yakaveh.finalbasket;


import com.kurdsoft.yakaveh.address.Address;
import com.kurdsoft.yakaveh.address.IAddressService;
import com.kurdsoft.yakaveh.basket.Basket;
import com.kurdsoft.yakaveh.basket.IBasketService;
import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import com.kurdsoft.yakaveh.supplier.ISupplierService;
import com.kurdsoft.yakaveh.supplier.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FinalBasketService implements IFinalBasketService{
    private final FinalBasketRep rep;
    private IAddressService addressService;
    private ISupplierService  supplierService;
    private IBasketService basketService;

    @Override
    public FinalBasket save(FinalBasket basket) {
        Long addressId=basket.getAddress().getId();
        Long supplierId=basket.getSupplier().getId();
        Long basketId=basket.getBasket().getId();
        Address address=addressService.getById(addressId);
        Supplier supplier=supplierService.getById(supplierId);
        Basket basket1=basketService.getById(basketId);
        basket.setBasket(basket1);
        basket.setAddress(address);
        basket.setSupplier(supplier);
        return rep.save(basket);
    }

    @Override
    public FinalBasket update(FinalBasket basket) {
        FinalBasket lastItem=getById(basket.getId());
        lastItem.setPaidPrice(basket.getPaidPrice());
        Long addressId=basket.getAddress().getId();
        Long supplierId=basket.getSupplier().getId();
        Long basketId=basket.getBasket().getId();
        Address address=addressService.getById(addressId);
        Supplier supplier=supplierService.getById(supplierId);
        Basket basket1=basketService.getById(basketId);
        lastItem.setBasket(basket1);
        lastItem.setAddress(address);
        lastItem.setSupplier(supplier);
        return rep.save(lastItem);
    }

    @Override
    public List<FinalBasket> getAll() {
        return (List<FinalBasket>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public FinalBasket getById(Long id) {
        Optional<FinalBasket> optionalFinalBasket=rep.findById(id);
        if(!optionalFinalBasket.isPresent()){
            throw  new NotFound("Not found Id.");
        }
        return optionalFinalBasket.get();
    }

    @Override
    public List<FinalBasket> getBySupplierId(Long id) {
        Supplier supplier=supplierService.getById(id);
        Long finalBasketId=supplier.getId();
        List<FinalBasket> finalBaskets=rep.findAllBySupplier_Id(finalBasketId);
        return finalBaskets;
    }

    @Override
    public List<FinalBasket> getByAddressId(Long id) {
        Address address=addressService.getById(id);
        Long finalBasketId=address.getId();
        List<FinalBasket> finalBaskets=rep.findAllByAddress_Id(finalBasketId);
        return finalBaskets;
    }

    @Override
    public List<FinalBasket> getByBasketId(Long id) {
        Basket basket=basketService.getById(id);
        Long finalBasketId=basket.getId();
        List<FinalBasket> finalBaskets=rep.findAllByBasket_Id(finalBasketId);
        return finalBaskets;
    }

    @Override
    public Page<FinalBasket> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

}
