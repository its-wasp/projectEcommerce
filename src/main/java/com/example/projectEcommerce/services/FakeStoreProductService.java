package com.example.projectEcommerce.services;

import com.example.projectEcommerce.dtos.FakeStoreProductDto;
import com.example.projectEcommerce.models.Category;
import com.example.projectEcommerce.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
@Service
public class FakeStoreProductService implements ProductService{
    public Product getProductById(Long id){
        /// call the FakeStore API to get the product with given id.

        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductdto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);

        // convert FakeStoreProductDto object to Product object.

        assert fakeStoreProductdto != null;
        return convertFakeStoreProductDtoToProduct(fakeStoreProductdto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                List.class);
        List<Product> products = new ArrayList<>();
        assert fakeStoreProductDtos != null;
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }
}
