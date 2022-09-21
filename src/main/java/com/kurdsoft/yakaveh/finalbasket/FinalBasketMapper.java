package com.kurdsoft.yakaveh.finalbasket;

import com.kurdsoft.yakaveh.items.Items;
import com.kurdsoft.yakaveh.items.ItemsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FinalBasketMapper {

    FinalBasket toFinalBasket(FinalBasketDTO finalBasketDTO);
    FinalBasketDTO toFinalBasketDto(FinalBasket basket);
    List<FinalBasket> toFinalBaskets(List<FinalBasketDTO> finalBasketDTOS);
    List<FinalBasketDTO> toFinalBasketDtos(List<FinalBasket> finalBasketList);
}
