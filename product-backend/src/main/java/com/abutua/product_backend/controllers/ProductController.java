package com.abutua.product_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.product_backend.models.Product;

@RestController
public class ProductController {
    
    @GetMapping("product")
    public Product getProduct(){
        Product p = new Product(1, "product 1", 1);

        return p;
    }

    @GetMapping("products")
    public List<Product> getProducts(){
        Product p1 = new Product(1, "product 1", 1);
        Product p2 = new Product(2, "product 2", 2);
        Product p3 = new Product(3, "product 3", 3);

        List<Product> listProd = new ArrayList<Product>();
        listProd.add(p1);
        listProd.add(p2);
        listProd.add(p3);

        return listProd;
    }
}
