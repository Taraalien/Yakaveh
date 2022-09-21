package com.kurdsoft.yakaveh.address;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IAddressService {
    Address save(Address address);
    Address update(Address  address);
    List<Address> getAll();
    void delete(Long id);
    Address getById(Long id);
    Page<Address> paging(Integer page, Integer size);

    List<Address>getByUserId(Long id);

}
