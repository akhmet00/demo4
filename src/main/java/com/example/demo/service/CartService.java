package com.example.demo.service;

import com.example.demo.model.Products;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CartService {
    void addProduct(Products products);
    void removeProduct(Products products);
    void clearProducts();
    Map<Products, Integer> productsInCart();
}
