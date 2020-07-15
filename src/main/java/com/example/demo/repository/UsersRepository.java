package com.example.demo.repository;


import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String userName);
    Users findById(Integer id);
    Users findByRoles(String roles);
    Users getMoneyByUserName(String userName);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Users u set u.money = ?1 where u.userName = ?2")
    int updateMoneyByUserName(BigDecimal money, String userName);

}