package com.example.api.service;

import com.example.api.dto.ProductDTO;
import com.example.api.entity.Category;
import com.example.api.entity.Product;
import com.example.api.repository.CategoryRepository;
import com.example.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements  CategoryService{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public List<Category> fetchCategories() {
        return categoryRepository.findAll();
    }



    @Override
    public Category updateCategory(Long categoryId,Category category) {
        Optional<Category> categoryDb = categoryRepository.findById(categoryId);
        if(categoryDb.isEmpty()){
            //todo :category not found exception
        }
        Category foundCategory = categoryDb.get();
        if(Objects.nonNull(category) && !"".equals(category.getName())){
            foundCategory.setName(category.getName());
        }

        return  categoryRepository.save(foundCategory);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Optional<Category> categoryDb = categoryRepository.findById(categoryId);
        if(categoryDb.isEmpty()){
            //todo :category not found exception
        }
        categoryRepository.deleteById(categoryId);
        return String.format("%s category has been deleted",categoryDb.get().getName());
    }

}
