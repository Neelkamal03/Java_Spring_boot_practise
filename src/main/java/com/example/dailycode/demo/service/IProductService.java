package com.example.dailycode.demo.service;

import com.example.dailycode.demo.model.Product;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product, Long prodId);
    void deleteProduct(Long productId);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
