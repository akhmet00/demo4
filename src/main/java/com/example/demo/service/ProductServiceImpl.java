package com.example.demo.service;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Products findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Products> findAll(String keyword, Pageable pageable) {
        return productRepository.findAll(keyword, pageable);
    }

    @Override
    public Page<Products> findAllByPrice(String category,BigDecimal min, BigDecimal max, Pageable pageable){
        return productRepository.findAllByPrice(category,min,max,pageable);
    }



    @Override
    public void edit(long id, Products products) {
        Products editProduct = productRepository.findById(id);
        editProduct.setId(id);
        editProduct.setProductName(products.getProductName());
        editProduct.setPrice(products.getPrice());
        editProduct.setImagesrc(products.getImagesrc());
        save(products);
    }

    @Override
    public void delete(long id){
        productRepository.delete(findById(id));
    }

    @Override
    public void save(Products products){
    productRepository.save(products);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

}
