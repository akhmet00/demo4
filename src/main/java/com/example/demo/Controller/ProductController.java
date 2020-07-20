package com.example.demo.Controller;


import com.example.demo.model.Products;
import com.example.demo.model.Users;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private  CartService CartService;

    @Autowired
    private  ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping({"","/","/index"})
    private String index(Model model,
                         @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable,
                         Authentication authenticated)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("url", "/index");
        model.addAttribute("products", productRepository.findAll(pageable));
        model.addAttribute("user", authenticated);

        logger.debug(String.format("User entered to main page"));
        return "index";
    }


    @GetMapping("/product/{id}")
    private String aboutProduct(@PathVariable("id") long id,
                            Model model,
                         Authentication authenticated)
    {

        model.addAttribute("product",productService.findById(id));
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("user", authenticated);
        model.addAttribute("url", "/product");

        logger.debug(String.format("User entered to product page"));
        return "about-product";
    }


    @GetMapping("/index/search")
    private String indexSearch(Model model,
                               @RequestParam("keyword") String keyword,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable,
                               Authentication authenticated)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("user", authenticated);

        if(keyword==null) {
            model.addAttribute("products", productRepository.findAll(pageable));
            model.addAttribute("url", "/index/search");
            logger.debug(String.format("User made search request"));
        }

        else {
            model.addAttribute("products", productRepository.findAll(keyword,pageable));
            model.addAttribute("url", "/index/search?keyword="+keyword);
            logger.debug(String.format("User made search request"));
        }
        return "search";
    }



    @GetMapping("/index/filter")
    private String indexFilter(Model model,
                               @RequestParam("category") String category,
                               @RequestParam("min") BigDecimal min,
                               @RequestParam("max") BigDecimal max,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable,
                               Authentication authenticated)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("url", "/index/filter?category="+category+"&min="+min+"&max="+max);
        model.addAttribute("products", productRepository.findAllByPrice(category,min,max,pageable));
        model.addAttribute("user", authenticated);

        logger.debug(String.format("User made filter request"));
        return "filter";
    }


    @GetMapping("/cart")
    public String cart(Model model, Users users,
                       Authentication authenticated)
    {
        model.addAttribute("totalPrice",CartService.totalPrice());
        model.addAttribute("products",CartService.productsInCart());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("money",userService.getMoneyByUserName(authenticated.getName()));
        model.addAttribute("user", authenticated);

        logger.debug(String.format("User %s entered to shopping cart",authenticated.getName()));
        return "shoping-cart";
    }


    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id)
    {
        Products products = productService.findById(id);
        System.out.println( productService.findById(id));

        if (products != null) {
            CartService.addProduct(products);
            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/index";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id)
    {
        Products products = productService.findById(id);
        if (products != null){
            CartService.removeProduct(products);
            logger.debug(String.format("Product with id: %s removed from shopping cart.", id));
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/clear")
    public String clearCart(Authentication authenticated)
    {
        CartService.clearProducts();
        logger.debug(String.format("User %s cleared cart",authenticated.getName()));
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(Users users, Authentication authenticated)
    {
        CartService.cartCheckout(authenticated);
        logger.debug(String.format("Username %s made checkout",authenticated.getName()));
        return "redirect:/cart";
    }

}
