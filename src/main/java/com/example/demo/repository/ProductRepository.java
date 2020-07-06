package com.example.demo.repository;

import com.example.demo.model.Products;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Products findById(Integer id);
    Products findByProductName(String productName);
    List<Products> findAllByOrderByIdAsc();

}
