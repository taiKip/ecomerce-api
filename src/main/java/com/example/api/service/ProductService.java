package com.example.api.service;
import com.example.api.dto.ProductDTO;
import org.springframework.data.domain.Page;
import com.example.api.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     Product createProduct(ProductDTO productDTO);

     List<Product> fetchProductList();

     Page <Product> fetchProductsByPage(int pageNumber, int pageSize);

     Product updateProduct(Long productId,ProductDTO product);

      String deleteProduct(Long productId);

    String featureProduct(Long productId);

}
