package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private Map<Products, Integer> cart = new LinkedHashMap<>();

    @Autowired
    private UserService userService;

    @Override
    public void addProduct(Products  products) {
        if (cart.containsKey(products)){
            cart.replace(products, cart.get(products) + 1);
        }else{
            cart.put(products, 1);
        }
    }

    @Override
    public void removeProduct(Products products) {
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


    @Override
    public Map<Products, Integer> productsInCart() {
        return Collections.unmodifiableMap(cart);
    }


    @Override
    public BigDecimal totalPrice() {

        return cart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }


    public Integer counter(){
        return cart.size();
    }

    @Override
    public void cartCheckout(Authentication authenticated) {
        Users money = userService.getMoneyByUserName(authenticated.getName());
        BigDecimal total = totalPrice();
        BigDecimal money2 = money.getMoney();
        Integer compareTo = money2.compareTo(total);

        if (compareTo==1){
            BigDecimal update =  money2.subtract(total);
            userService.updateMoneyByUserName(update,authenticated.getName());
            cart.clear();
        }
    }

}
