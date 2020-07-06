package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Products findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Products> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void edit(Integer id, Products products) {
        Products editProduct = productRepository.findById(id);
        editProduct.setProductName(products.getProductName());
        editProduct.setImagesrc(products.getImagesrc());
        editProduct.setQuantity(products.getQuantity());
        editProduct.setPrice(products.getPrice());
        save(products);
    }

    @Override
    public void delete(Integer id){
        productRepository.delete(findById(id));
    }

    @Override
    public void save(Products products){
    productRepository.save(products);
    }

}
