package com.kurdsoft.yakaveh.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRep extends PagingAndSortingRepository<Address,Long> {

    List<Address> findAllByUser_Id(Long userId);
    Page<Address> findAll(Pageable pageable);
}
