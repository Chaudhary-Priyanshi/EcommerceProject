package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(int id);
    public List<Product> getAllProduct();
    public Product addProduct(String title, String description, double price, String imageUrl, String categoryName);
}
