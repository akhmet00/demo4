package com.example.demo.repository;

import com.example.demo.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findById(long id);

    Products findByProductName(String productName);

    @Query("SELECT p FROM Products p WHERE p.productName LIKE %?1% " +
            " OR p.type LIKE %?1%")
    Page<Products> findAll(String keyword,Pageable pageable);

    @Query("SELECT p FROM Products p WHERE p.type LIKE %?1% AND p.price BETWEEN ?2 AND ?3")
    Page<Products> findAllByPrice(String category,BigDecimal min, BigDecimal max, Pageable pageable);



//    @Query("SELECT p FROM Products p WHERE p.productName LIKE %?1% ")
//    List<Products> findAllByProductName(String keyword);


}
