package com.example.productservice.dto;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public static ProductResponseDto fromProduct(Product product) {

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setCategoryName(product.getCategory().getName());

        return productResponseDto;
    }
}
