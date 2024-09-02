package com.example.productservice.controllers;

import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/{Id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable int Id){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(Id);
        productResponseDto.setDescription("This is a product");
        productResponseDto.setPrice(120);

        ResponseEntity<ProductResponseDto> responseEntity = new ResponseEntity<ProductResponseDto>(productResponseDto, HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    @GetMapping
    public String getAllProduct(){
        return "Hello world";
    }

    public void createProduct(){

    }

    public void updateProduct(){

    }

    public void deleteProduct(){

    }
}
