package com.example.demo.service;


import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private final UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName){

        Users users = usersRepository.findByUserName(userName);

        if (users != null) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            if (Objects.equals(users.getRoles(),"ROLE_ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }else {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            logger.debug(String.format("User with role: %s , name: %s and password: %s created.",authorities, users.getUserName(), users.getPassword()));
            return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(),authorities);
        }else{
            throw new UsernameNotFoundException("User " + userName + " not found!");
        }
    }
}
