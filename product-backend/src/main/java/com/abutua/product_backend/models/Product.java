package com.abutua.product_backend.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean promotion;
    private boolean newProduct;
    private Category category;

    

    public Product(int id, String name, String description, double price, boolean promotion, boolean newProduct,
            Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.promotion = promotion;
        this.newProduct = newProduct;
        this.category = category;
    }

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(){

    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}
