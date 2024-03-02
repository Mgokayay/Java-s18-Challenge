package com.workintech.s18challenge.service;

import com.workintech.s18challenge.entity.Category;
import com.workintech.s18challenge.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() -> new RuntimeException("Category not found " + id));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category oldCategory = findById(category.getId());
        oldCategory.setName(category.getName());
        return categoryRepository.save(oldCategory);

    }
}
