package com.example.demo.service;

import com.example.demo.model.Users;

import java.math.BigDecimal;

public interface UserService {

    void save(Users users);
    void delete(Integer id);
    //void edit(Integer id, Users users);
    void login(String userName, String password);
    Users findByUserName(String userName);
    Users findById(Integer id);
    Users findByRoles(String roles);
    Users getMoneyByUserName(String userName);

    int updateMoneyByUserName(BigDecimal money, String userName);

}
