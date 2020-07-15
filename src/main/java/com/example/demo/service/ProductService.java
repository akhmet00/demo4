package com.example.demo.service;

import com.example.demo.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ProductService {

    void delete(long id);
    void save(Products products);
    void edit(long id, Products products);

    Products findById(long id);

    Page<Products> findAll(String keyword,Pageable pageable);
    Page<Products> findAllByPrice(String category,BigDecimal min, BigDecimal max, Pageable pageable);

    long count();
}
