package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id) throws ProductNotFoundException;
    public List<Product> getAllProduct();
    public Product addProduct(String title, String description, double price, String imageUrl, String categoryName);
    public Product createProduct(Product product);
    public void deleteProductById(Long id) throws ProductNotFoundException;
}
