package com.example.demo.Controller;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductRestController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private  ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/admin")
    public String admin(Model model){
        return "admin";
    }


    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/admin/products/new")
    public String newProduct(Model model) {
        model.addAttribute("products", new Products());
        return "newProduct";
    }

    @PostMapping("/admin/products/new")
    public String newProduct(@ModelAttribute("products") Products products, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
            return "redirect:/admin/products";
        }
        productService.save(products);
        logger.debug(String.format("Product with id: %s successfully created.", products.getId()));

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        Products products = productService.findById(id);
        if (products != null){
            model.addAttribute("products", products);
            model.addAttribute("method", "edit");
            return "redirect:/admin/products";
        }else {
            return "error/404";
        }
    }

    @PostMapping("/admin/products/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, @ModelAttribute("products") Products products, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "edit");
            return "redirect:/admin/products";
        }
        productService.edit(id, products);
        logger.debug(String.format("Product with id: %s has been successfully edited.", id));

        return "redirect:/admin/products";
    }

    @PostMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        Products products = productService.findById(id);
        if (products != null){
            productService.delete(id);
            logger.debug(String.format("Product with id: %s successfully deleted.", products.getId()));
            return "redirect:/admin/products";
        }else {
            return "error/404";
        }
    }
}
