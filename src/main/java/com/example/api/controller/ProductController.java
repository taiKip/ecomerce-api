package com.example.api.controller;

import com.example.api.entity.Product;
import com.example.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private static Logger LOGGER= LoggerFactory.getLogger(Slf4j.class);
    @GetMapping
    public List<Product> fetchProducts(){
LOGGER.debug("fetchProducts controller");
        return  productService.fetchProductList();
    }

    @GetMapping(path = "page")
    public Page<Product> fetchProductsByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
        return productService.fetchProductsByPage(pageNumber,pageSize);
    }

}
