package com.abutua.product_backend.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.product_backend.models.Product;

@RestController
@CrossOrigin
public class ProductController {
    // private List<Category> categories = Arrays.asList( 
    //     new Category(1, "Produção Própria"),
    //     new Category(2, "Nacional"),
    //     new Category(3, "Importado"),
    //     new Category(4, "Premium")
    // );

    private List<Product> products = new ArrayList<>();
    

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

    @PostMapping("products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        product.setId(products.size()+1);
        products.add(product);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(product.getId())
        .toUri();

        return ResponseEntity.created(location).body(product);
    }
}
