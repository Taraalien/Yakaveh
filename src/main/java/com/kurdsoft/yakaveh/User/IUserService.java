package com.kurdsoft.yakaveh.User;

import com.kurdsoft.yakaveh.basket.Basket;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {
    User save(User user);
    User update(User  user);
    List<User> getAll();
    void delete(Long id);
    User getById(Long id);
    Page<User> paging(Integer page, Integer size);
}
