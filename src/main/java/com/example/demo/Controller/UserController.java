package com.example.demo.Controller;


import com.example.demo.DemoApplication;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.MyUserDetailsService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private UsersRepository usersRepository;

   Logger logger = LoggerFactory.getLogger(UserController.class);


    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    @GetMapping("/")
    private String user(){
        return "/register";
    }

    @GetMapping("/login")
    private String login(Authentication authentication){
        logger.debug("Request: Login try by User: "+authentication.getName());

        return "redirect:/shop";
    }

    @GetMapping("/register")
    private String register(){
        return "register";
    }

    @PostMapping("/registerUser")
    private String registerUser(
            @ModelAttribute("users") Users users,
            Map<String,Object> model){
            logger.debug("Request: register new user");
                usersRepository.findByUserName(users.getUserName());
                users.setActive(true);
                users.setPassword(hashPassword(users.getPassword()));
                users.setCompanyname(users.getCompanyname());
                users.setRoles("ROLE_USER");
                usersRepository.save(users);
            logger.debug("Response: registered successfully new User:" + users.getUserName());
            return "redirect:/login";
    }


    @PostMapping("/admin/users/insert")
    private String insert(@RequestParam String userName,
                          @RequestParam String password,
                          @RequestParam String companyname,
                          Model model, Authentication authentication){
        logger.debug("Request: insert by User: "+ authentication.getName());
        Users users = new Users(userName,hashPassword(password),companyname);
        users.setActive(true);
        users.setRoles("ROLE_USER");
        usersRepository.save(users);
        logger.debug("Response: insert done by User: "+authentication.getName());
        return "redirect:/admin/users";
    }


    @GetMapping("/admin/users")
    private String user(Model model){
        model.addAttribute("users", usersRepository.findAll());
        return "user";
    }


    @PostMapping("/admin/users/delete/{userName}")
    private String delete(@PathVariable(value = "userName") String userName, Authentication authentication){
    logger.debug("Request: delete by User: " + authentication.getName());
    Users users = usersRepository.findByUserName(userName).orElseThrow(IllegalStateException::new);
    usersRepository.delete(users);
    logger.debug("Response: delete done by User: " + authentication.getName());
        return "redirect:/admin/users";
    }




}
