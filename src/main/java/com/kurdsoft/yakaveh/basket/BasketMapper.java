package com.kurdsoft.yakaveh.basket;

import com.kurdsoft.yakaveh.category.Category;
import com.kurdsoft.yakaveh.category.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BasketMapper {

    Basket toBasket(BasketDTO basketDTO);
    BasketDTO toBasketDto(Basket basket);

    List<Basket>toBasketList(List<BasketDTO> basketDTOS);
    List<BasketDTO> toBasketDtos(List<Basket> baskets);
}
