package com.example.api.service;

import com.example.api.dto.ProductDTO;
import com.example.api.entity.Category;
import com.example.api.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(Category category);


    List<Category> fetchCategories();

     Category updateCategory(Long categoryId,Category category);
     String deleteCategory(Long categoryId);
}
