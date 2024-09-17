package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with id "+id+" not found.");
        }

        return product.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(String title, String description, double price, String imageUrl, String categoryName) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {

        Category category = product.getCategory();
        if(category.getId() == null){
            Category newCategory = categoryRepository.save(category);
            product.setCategory(newCategory);
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException{
        Product product = getProductById(id);
        productRepository.deleteById(id);
    }

}
