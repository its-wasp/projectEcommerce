package com.example.projectEcommerce.services;

import com.example.projectEcommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
