package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Username cannot be empty! ")
    private String userName;
    @NotBlank(message = "Password cannot be empty! ")
    private String password;
    private boolean active;
    private String roles;
    private String companyname;
    private BigDecimal money;

    public Users() {

    }

    public Users(@NotBlank(message = "Username cannot be empty! ") String userName,
                 @NotBlank(message = "Password cannot be empty! ") String password,
                 String companyname) {
        this.userName = userName;
        this.password = password;
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                ", companyname='" + companyname + '\'' +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCompanyname() { return companyname; }

    public void setCompanyname(String companyname) { this.companyname = companyname; }

    public  BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
