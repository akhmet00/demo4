package com.example.demo.Controller;

import com.example.demo.Controller.jwt.JwtTokenProvider;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRestController {



    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @RequestMapping(value = "/admin/users/new", method = RequestMethod.POST)
    public ResponseEntity newUser(@RequestBody Users users,
                                  BindingResult bindingResult,
                                  Model model)
    {

        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
            model.addAttribute("method", "new");
        }
        userService.save(users);
        logger.debug(String.format("User with id: %s successfully created.", users.getId()));
        Map<Object, Object> response = new HashMap<>();
        response.put("users",users);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/restlogin", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody Users users)
    {
        try {
            String username = users.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, users.getPassword()));
            Users user = userService.findByUserName(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            logger.debug(String.format("User %s received token %s",username,token));
            return ResponseEntity.ok(response);

            } catch (AuthenticationException e)
        {
            throw new BadCredentialsException("Invalid username or password");
        }
    }


    @RequestMapping(value = "/admin/users", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> listAllUsers()
    {

        List<Users> users;
        try {
              users = usersRepository.findAll();
              logger.debug(String.format("List all users request"));
            } catch (PersistenceException e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (users.isEmpty())
        {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);

    }



    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteUser(@PathVariable("id") Integer id)
    {
        try {
            Users users = userService.findById(id);

            if (users == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            userService.delete(id);
            logger.debug(String.format("User with id: %s deleted by admin",id));
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
