package com.kurdsoft.yakaveh.items;

import com.kurdsoft.yakaveh.basket.BasketMapper;
import com.kurdsoft.yakaveh.supplier_category.SupplierCatMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierCatMapper.class, BasketMapper.class})
public interface ItemsMapper {

    Items toItems(ItemsDTO itemsDTO);
    ItemsDTO toItemsDto(Items items);
    List<Items> toItemsList(List<ItemsDTO> itemsDTOS);
    List<ItemsDTO> toItemsDtos(List<Items> items);
}
