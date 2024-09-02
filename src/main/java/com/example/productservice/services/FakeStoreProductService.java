package com.example.productservice.services;

import com.example.productservice.dto.FakeStoreProductRequestDto;
import com.example.productservice.dto.FakeStoreProductResponseDto;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(int Id) {
        FakeStoreProductResponseDto fakeStoreProductResponseDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + Id, FakeStoreProductResponseDto.class);
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

}
