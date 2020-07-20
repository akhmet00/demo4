package com.example.demo.Controller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String userLogin()
    {
        logger.debug(String.format("Login page request"));
        return "login";
    }

    @GetMapping("/login/authorize")
    public String userLoginRequest(@RequestParam("userName") String userName,
                                   @RequestParam("password") String password)
    {
        userService.login(userName,password);
        logger.debug(String.format("Login try by User: %s",userName));
        return "redirect:/index";
    }

    @GetMapping("/register")
    public String registerUser()
    {
        logger.debug(String.format("Register page request"));
        return "register";
    }

    @PostMapping("/register/new")
    public String registerUserRequest(@ModelAttribute("users") Users users,
                                      BindingResult bindingResult,
                                      Model model,
                                      @RequestParam("userName") String userName)
    {
        Users user = userService.findByUserName(userName);
        if(bindingResult.hasErrors() || user!=null){
            model.addAttribute("message", "This user already exists!");
            return "register";
        }
        userService.save(users);
        logger.debug(String.format("Register try"));
        return "redirect:/login";
    }

}
