package com.example.api.service;

import com.example.api.dto.ProductDTO;
import com.example.api.entity.Category;
import com.example.api.entity.Product;
import com.example.api.entity.User;
import com.example.api.repository.CategoryRepository;
import com.example.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductDTO productDTO) {

        Optional<Category> category = categoryRepository.findById(productDTO.categoryId());
        if (category.isEmpty()) {
            //todo category not found error
        }
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setCategory(category.get());
        product.setPrice(productDTO.price());


        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> fetchProductsByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        return productRepository.findAll(pageable);
    }

    @Override
    public Product updateProduct(Long productId, ProductDTO product) {
        Optional<Product> productDb = productRepository.findById(productId);

        if (productDb.isEmpty()) {
            //todo
        }
        Product foundProduct = productDb.get();
        if (Objects.nonNull(product) && !"".equals(product.name())) {
            foundProduct.setName(product.name());
        }
        if (Objects.nonNull(product) && !"".equals(product.imageUrl())) {
            foundProduct.setImageUrl(product.imageUrl());
        }
        if (Objects.nonNull(product) && !"".equals(product.description())) {
            foundProduct.setDescription(product.description());
        }
        if (Objects.nonNull(product) && product.inventory() >= 0) {
            foundProduct.setInventory(product.inventory());
        }
        if (Objects.nonNull(product) && product.price() > 0) {
            foundProduct.setPrice(product.price());
        }
        if (Objects.nonNull(product) && product.categoryId() >= 0) {
            Category category = categoryRepository.findById(product.categoryId()).get();
            foundProduct.setCategory(category);
        }

        return productRepository.save(foundProduct);
    }

    @Override
    public String deleteProduct(Long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        if (productDb.isEmpty()) {
            //todo :product not found exception
        }
        categoryRepository.deleteById(productId);
        return String.format("%s category has been deleted", productDb.get().getName());
    }

    @Override
    public String featureProduct(Long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        if (productDb.isEmpty()) {
            //todo throw user not found error
        }
        if(productDb.get().isFeatured()){
            productDb.get().setFeatured(false);
            productRepository.save(productDb.get());
            return String.format("%s has been removed from  featured products", productDb.get().getName());
        }
        else {
            productDb.get().setFeatured(true);
            productRepository.save(productDb.get());
        }


        return String.format("%s has been added to featured products", productDb.get().getName());
    }


}
