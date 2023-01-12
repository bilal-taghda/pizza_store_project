package com.project.pizza.domain.entity;

public abstract class SecurePasswordAbstract implements ISecurePassword{

    @Override
    public abstract Boolean isSecure(String psw);
    @Override
    public abstract Boolean hasCapitalLetter(String psw);
    @Override
    public abstract Boolean hasNumber(String psw);
}
