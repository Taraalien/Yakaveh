package com.kurdsoft.yakaveh.category;

import com.kurdsoft.yakaveh.common.exceptions.NotFound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRep categoryRep;
    @Override
    public Category save(Category category) {

        return categoryRep.save(category);
    }

    @Override
    public Category update(Category category) {
        Category lastItem=getById(category.getId());
        lastItem.setTitle(category.getTitle());
        lastItem.setIcon(category.getIcon());
        lastItem.setType(category.getType());
        return categoryRep.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        Optional<Category> categoryOptional=categoryRep.findById(id);
        if(!categoryOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        categoryRep.deleteById(id);
    }

    @Override
    public Category getById(Long id) {
        Optional<Category> categoryOptional=categoryRep.findById(id);
        if(!categoryOptional.isPresent()){
            throw  new NotFound("Not Found Id.");
        }
        return categoryOptional.get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>)categoryRep.findAll();
    }

    @Override
    public Page<Category> paging(Integer page, Integer size) {
        return categoryRep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
