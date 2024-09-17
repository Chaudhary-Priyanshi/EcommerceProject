package com.example.productservice.controllers;

import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) throws ProductNotFoundException {

        return productService.getProductById(id);

//        ProductResponseDto productResponseDto = new ProductResponseDto();
//        productResponseDto.setId(id);
//        productResponseDto.setDescription("This is a product");
//        productResponseDto.setPrice(120);
//        ResponseEntity<ProductResponseDto> responseEntity = new ResponseEntity<ProductResponseDto>(productResponseDto, HttpStatusCode.valueOf(200));
//        return responseEntity;
    }

    @GetMapping
    public List<Product> getAllProduct(){

        return productService.getAllProduct();
    }

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product){


    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteProductById(id);
        return "Product with id "+id+" is successfully deleted.";
    }
}
