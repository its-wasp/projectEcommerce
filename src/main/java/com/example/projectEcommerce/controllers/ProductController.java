package com.example.projectEcommerce.controllers;

import com.example.projectEcommerce.dtos.FakeStoreProductDto;
import com.example.projectEcommerce.models.Product;
import com.example.projectEcommerce.services.FakeStoreProductService;
import com.example.projectEcommerce.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController { // waiter
    //localhost:8080/products/get/10
    ProductService productService;  // chef

    public ProductController(FakeStoreProductService fakeStoreProductService){
        this.productService = fakeStoreProductService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);

        return product;
    }
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
