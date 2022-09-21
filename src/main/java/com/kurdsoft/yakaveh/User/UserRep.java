package com.kurdsoft.yakaveh.User;

import com.kurdsoft.yakaveh.basket.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRep extends PagingAndSortingRepository<User,Long> {

    Page<User> findAll(Pageable pageable);
}
