package com.example.productservice.controllers;

import com.example.productservice.dto.FakeStoreProductResponseDto;
import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class FakeStoreProductController {

    private ProductService productService;

    public FakeStoreProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{Id}")
    public ProductResponseDto getProductById(@PathVariable ("Id") int Id) {

        Product product = productService.getProductById(Id);
        return ProductResponseDto.fromProduct(product);
    }

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {

        List<Product> products = productService.getAllProduct();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            productResponseDtos.add(ProductResponseDto.fromProduct(product));
        }
        return productResponseDtos;
    }

    @PostMapping
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) {

        Product newProduct = productService.addProduct(productRequestDto.getTitle(), productRequestDto.getDescription(),
                                                       productRequestDto.getPrice(), productRequestDto.getImageUrl(),
                                                       productRequestDto.getCategoryName());
        return ProductResponseDto.fromProduct(newProduct);
    }
}
