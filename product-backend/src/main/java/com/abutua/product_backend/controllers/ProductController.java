package com.abutua.product_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.product_backend.models.Product;

@RestController
public class ProductController {
    
    @GetMapping("product")
    public Product getProduct(){
        Product p = new Product(1, "leite", 4.50);

        return p;
    }
}
