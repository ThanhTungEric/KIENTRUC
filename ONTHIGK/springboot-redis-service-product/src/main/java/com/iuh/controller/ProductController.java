package com.iuh.controller;


import com.iuh.model.Product;
import com.iuh.repository.RedisProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private RedisProductRepository productRepository;

    @PostMapping
    public Product save(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String productId){
        return productRepository.findById(productId);
    }
}
