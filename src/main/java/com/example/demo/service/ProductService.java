package com.example.demo.service;

import com.example.demo.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void delete(Integer id);
    void save(Products products);
    void edit(Integer id, Products products);
    Products findById(Integer id);
    List<Products> findAllByOrderByIdAsc();
}
