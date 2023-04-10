package com.example.api.controller;

import com.example.api.dto.ProductDTO;
import com.example.api.dto.UserDTO;
import com.example.api.entity.Category;
import com.example.api.entity.Product;
import com.example.api.repository.ProductRepository;
import com.example.api.service.CategoryService;
import com.example.api.service.ProductService;
import com.example.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    /**
     * @desc fetch all users
     * @route Get /users
     * @access Private -Admin role
     */
    @GetMapping(path = "users")
    public List<UserDTO> fetchUsers() {
        return userService.fetchUsers();
    }

    /**
     @desc fetch all users
     @route Get /users
     @access Private -Admin role
     */
//    @GetMapping(path="users")
//    public Page<UserDTO> fetchUsersByPage(@RequestParam int pageNumber,@RequestParam int pageSize) {
//        return userService.fetchUsersByPage(pageNumber,pageSize);
//    }

    /**
     * @desc Ban User
     * @route PUT
     * @access Private -Admin role
     */
    @PutMapping(path = "users/{userId}")
    public ResponseEntity<String> banUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.banUser(userId));
    }

    /**
     * @desc Create Category
     * @route POST
     * @access Private -Admin role
     */
    @PostMapping(path = "categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    /**
     * @desc Update Category
     * @route PUT
     * @access Private -Admin role
     */
    @PutMapping(path = "categories/{categoryId}")
    public ResponseEntity<Category> createCategory(@PathVariable("categoryId") Long categoryId ,@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId,category));
    }
    /**
     * @desc Delete  Category
     * @route DELETE
     * @access Private -Admin role
     */
    @DeleteMapping (path = "categories/{categoryId}")
    public ResponseEntity<String> createCategory(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }
    /**
     * @desc Create Product
     * @route POST /create
     * @access Private -Admin role
     */
    @PostMapping(path = "products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }


    /**
     * @desc Update product
     * @route UPDATE
     * @access Private -Admin role
     */
    @PutMapping(path = "products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId")Long productId,@RequestBody ProductDTO product) {
        return ResponseEntity.ok(productService.updateProduct(productId,product));
    }
    /**
     * @desc Delete product
     * @route DELETE
     * @access Private -Admin role
     */
    @DeleteMapping(path = "products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId")Long productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
    @PutMapping(path = "products/{productId}/feature")
    public ResponseEntity<String> featureProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.featureProduct(productId));
    }

}
