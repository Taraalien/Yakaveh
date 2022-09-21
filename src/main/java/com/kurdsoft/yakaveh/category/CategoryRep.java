package com.kurdsoft.yakaveh.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRep extends PagingAndSortingRepository<Category,Long> {

        Page<Category> findAll(Pageable pageable);
}
