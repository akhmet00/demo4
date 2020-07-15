package com.example.demo.service;

import com.example.demo.model.Products;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public interface CartService {

    void addProduct(Products products);
    void removeProduct(Products products);
    void clearProducts();
    Map<Products, Integer> productsInCart();
    BigDecimal totalPrice();
    Integer counter();
    void cartCheckout(Authentication authenticated);

}
