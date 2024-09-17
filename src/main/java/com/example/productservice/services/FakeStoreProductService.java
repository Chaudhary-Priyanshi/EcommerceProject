package com.example.productservice.services;

import com.example.productservice.dto.FakeStoreProductRequestDto;
import com.example.productservice.dto.FakeStoreProductResponseDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductResponseDto.class);

        if(fakeStoreProductResponseDto == null) {
           throw new ProductNotFoundException("Product with product id "+id+" is not found");
        }

        return fakeStoreProductResponseDto.toProduct();
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreProductResponseDto[] fakeStoreProductResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductResponseDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductResponseDto fakeStoreProductResponseDto1 : fakeStoreProductResponseDto) {
            products.add(fakeStoreProductResponseDto1.toProduct());
        }
        return products;
    }

    @Override
    public Product addProduct(String title, String description, double price, String imageUrl, String categoryName) {
        FakeStoreProductRequestDto fakeStoreProductRequestDto = new FakeStoreProductRequestDto();
        fakeStoreProductRequestDto.setTitle(title);
        fakeStoreProductRequestDto.setDescription(description);
        fakeStoreProductRequestDto.setPrice(price);
        fakeStoreProductRequestDto.setImage(imageUrl);
        fakeStoreProductRequestDto.setCategory(categoryName);

        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.postForObject(
                "https://fakestoreapi.com/products", fakeStoreProductRequestDto, FakeStoreProductResponseDto.class);

        return fakeStoreProductResponseDto.toProduct();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {

    }

}
