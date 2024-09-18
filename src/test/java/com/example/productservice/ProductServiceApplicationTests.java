package com.example.productservice;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import com.example.productservice.repositories.projections.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCustomQueries1() {
        Product product = productRepository.customQuery1();
        System.out.println(product.getTitle());
        System.out.println("DEBUG");
    }

    @Test
    public void testCustomQueries2() {
        List<Product> product = productRepository.customQuery2(1L);
        System.out.println(product);
        System.out.println("DEBUG");
    }

    @Test
    public void testCustomQueries3() {
        List<ProductWithIdAndTitle> product = productRepository.customQuery3(1L);

        for (ProductWithIdAndTitle productWithIdAndTitle : product) {
            System.out.println(productWithIdAndTitle.getId());
            System.out.println(productWithIdAndTitle.getTitle());
        }

        System.out.println("DEBUG");
    }
}
