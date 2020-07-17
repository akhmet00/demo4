package com.example.demo.Controller;

import com.example.demo.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private CartService CartService;

    @GetMapping("/contacts")
    public String contacts(Model model, Authentication authenticated){
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("user", authenticated);

        logger.debug(String.format("User made request to contacts"));
        return "contacts";
    }

    @GetMapping("/shop-details")
    public String shopDetails(Model model, Authentication authenticated){
        model.addAttribute("totalPrice", CartService.totalPrice());
        model.addAttribute("count", CartService.counter());
        model.addAttribute("user", authenticated);
        logger.debug(String.format("User made request to shop details"));
        return "shop-details";
    }
}
