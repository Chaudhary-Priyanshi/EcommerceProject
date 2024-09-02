package com.example.productservice.dto;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private int id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(Double.valueOf(this.price));

        Category category = new Category();
        category.setName(this.category);

        product.setCategory(category);

        return product;
    }
}
