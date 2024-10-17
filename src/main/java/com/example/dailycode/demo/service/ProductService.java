package com.example.dailycode.demo.service;

import com.example.dailycode.demo.model.Product;
import com.example.dailycode.demo.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//public List<Product> products= Arrays.asList(
//        new Product(1L, "SmartPhone123", 100, "Good SmartPhone",123),
//        new Product(2L, "SmartPhone", 101, "Good SmartPhone",11),
//        new Product(3L, "SmartPhone", 102, "Good SmartPhone",12),
//        new Product(4L, "SmartPhone11", 103, "Good SmartPhone1221", 14)
//
//);


@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long prodId) {
       if(productRepository.findById(prodId).isPresent()){
           return productRepository.save(product);
       }
       return null;
    }

    @Override
    public void deleteProduct(Long productId) {
       if(productRepository.findById(productId).isPresent()){
           productRepository.deleteById(productId);
       }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
