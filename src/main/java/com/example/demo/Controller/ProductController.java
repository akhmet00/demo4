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

import javax.servlet.http.HttpServletRequest;
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
                         @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("url", "/index");
        model.addAttribute("products", productRepository.findAll(pageable));

        return "index";
    }


    @GetMapping("/index/search")
    private String indexSearch(Model model,
                               @RequestParam("keyword") String keyword,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());

        if(keyword==null) {
            model.addAttribute("products", productRepository.findAll(pageable));
            model.addAttribute("url", "/index/search");
        }

        else {
            model.addAttribute("products", productRepository.findAll(keyword,pageable));
            model.addAttribute("url", "/index/search?keyword="+keyword);
        }
        return "search";
    }



    @GetMapping("/index/filter")
    private String indexFilter(Model model,
                               @RequestParam("category") String category,
                               @RequestParam("min") BigDecimal min,
                               @RequestParam("max") BigDecimal max,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable,
                               HttpServletRequest request)
    {
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("url", "/index/filter?category="+category+"&min="+min+"&max="+max);
        model.addAttribute("products", productRepository.findAllByPrice(category,min,max,pageable));

        return "filter";
    }


    @GetMapping("/cart")
    public String cart(Model model, Users users,
                       Authentication authenticated)
    {
        model.addAttribute("products",CartService.productsInCart());
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("money",userService.getMoneyByUserName(authenticated.getName()));
        model.addAttribute("user", authenticated);

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
    public String clearCart()
    {
        CartService.clearProducts();
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String cartCheckout(Users users, Authentication authenticated)
    {
        CartService.cartCheckout(authenticated);
        return "redirect:/cart";
    }

}
