package com.example.demo.service;

import com.example.demo.model.Products;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private Map<Products, Integer> cart = new LinkedHashMap<>();

    @Override
    public Map<Products, Integer> productsInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public void addProduct(Products products) {
        if (cart.containsKey(products)){
            cart.replace(products, cart.get(products) + 1);
        }else{
            cart.put(products, 1);
        }
    }

    @Override
    public void removeProduct(Products products){
        if (cart.containsKey(products)) {
            if (cart.get(products) > 1)
                cart.replace(products, cart.get(products) - 1);
            else if (cart.get(products) == 1) {
                cart.remove(products);
            }
        }
    }

    @Override
    public void clearProducts() {
        cart.clear();
    }

}
