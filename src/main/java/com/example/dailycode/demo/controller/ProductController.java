package com.example.dailycode.demo.controller;

import com.example.dailycode.demo.model.Product;
import com.example.dailycode.demo.service.IProductService;
import com.example.dailycode.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}/product")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product,@RequestParam Long id){
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
