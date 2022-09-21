package com.kurdsoft.yakaveh.category;


import com.kurdsoft.yakaveh.common.PagingData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category/")
public class CategoryController {

    private final ICategoryService service;
    private CategoryMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO){
        Category category=mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CategoryDTO categoryDTO){
        Category category=mapper.toCategory(categoryDTO);
        service.update(category);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category category = service.getById(id);
        CategoryDTO dto = mapper.toCategoryDto(category);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<Category>categories=service.getAll();
        List<CategoryDTO>categoryDTOS=mapper.toCategoryDtos(categories);
        return ResponseEntity.ok(categoryDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<CategoryDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Category> categories=service.paging(page,size);
        int totalPage=categories.getTotalPages();
        List<Category> data=categories.getContent();
        List<CategoryDTO> categoryDTOS=mapper.toCategoryDtos(data);
        PagingData<CategoryDTO> pagingData=new PagingData<>(totalPage,page,categoryDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
