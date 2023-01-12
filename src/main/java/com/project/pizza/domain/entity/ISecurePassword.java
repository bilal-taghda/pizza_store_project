package com.project.pizza.domain.entity;

public interface ISecurePassword {
    public Boolean isSecure(String psw);
    public Boolean hasCapitalLetter(String psw);
    public Boolean hasNumber(String psw);

}
