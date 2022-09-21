package com.kurdsoft.yakaveh.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDTO categoryDTO);
    CategoryDTO toCategoryDto(Category category);

    List<Category> toCategoryList(List<CategoryDTO> categoryDTOS);
    List<CategoryDTO> toCategoryDtos(List<Category> categories);
}
