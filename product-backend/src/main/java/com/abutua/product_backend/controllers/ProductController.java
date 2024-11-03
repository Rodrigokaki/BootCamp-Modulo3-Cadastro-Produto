package com.abutua.product_backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.product_backend.models.Category;
import com.abutua.product_backend.models.Product;

@RestController
@CrossOrigin
public class ProductController {
    private List<Category> categories = Arrays.asList( 
        new Category(1, "Produção Própria"),
        new Category(2, "Nacional"),
        new Category(3, "Importado")
    );

    private List<Product> products = Arrays.asList( 
        new Product(1, "product 1","Description 1", 1, false, false, categories.get(0)),
        new Product(2, "product 2", "Description 2", 2, true, false, categories.get(1)),
        new Product(3, "product 3", "Description 3", 3, false, true, categories.get(2))
    );

    @GetMapping("products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id){

        // if(id <= products.size() && id > 0){
        //     return ResponseEntity.ok(products.get(id-1));
        // }
        // else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        // }

        Product prod = products.stream()
                                .filter(p -> p.getId() == id).findFirst()
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> getProducts(){ 
        return products;
    }
}
