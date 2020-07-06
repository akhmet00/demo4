package com.example.demo.Controller;


import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private  CartService CartService;

    @Autowired
    private  ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/shop")
    private String shop(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "shop";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("products",CartService.productsInCart());
       // model.addAttribute("totalPrice", CartService.totalPrice());

        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") Integer id){
        Products products = productService.findById(id);
        if (products != null) {
            CartService.addProduct(products);
        }
        logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        return "redirect:/shop";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") Integer id){
        Products products = productService.findById(id);
        CartService.removeProduct(products);
        logger.debug(String.format("Product with id: %s removed from shopping cart.", id));
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(){
        CartService.clearProducts();
        return "redirect:/cart";
    }



}
