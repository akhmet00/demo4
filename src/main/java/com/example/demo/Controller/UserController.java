package com.example.demo.Controller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }

    @GetMapping("/login/authorize")
    public String userLoginRequest(@RequestParam("userName") String userName,
                                   @RequestParam("password") String password)
    {
        userService.login(userName,password);
        return "redirect:/index";
    }

    @GetMapping("/register")
    public String registerUser(){
        return "register";
    }

    @PostMapping("/register/new")
    public String registerUserRequest(@ModelAttribute("users") Users users,
                                      BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "register";
        }
        userService.save(users);
        return "redirect:/login";
    }

}
