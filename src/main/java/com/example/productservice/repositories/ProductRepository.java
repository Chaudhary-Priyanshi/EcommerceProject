package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(long id);

    List<Product> findAll();

    Product save(Product product);

    Product deleteById(long id);

    @Query("Select p from Product p where p.id = 1")
    Product customQuery1();

    @Query("SELECT p from Product p where p.category.id = :id")
    List<Product> customQuery2(@Param("id") Long id);

    @Query("SELECT p.id as id, p.title as title from Product p where p.category.id = :id ")
    List<ProductWithIdAndTitle> customQuery3(@Param("id") Long id);
}
