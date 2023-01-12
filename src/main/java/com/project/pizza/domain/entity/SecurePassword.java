package com.project.pizza.domain.entity;

public class SecurePassword extends SecurePasswordAbstract {

    @Override
    public Boolean isSecure(String psw) {
        return hasCapitalLetter(psw) && hasNumber(psw);
    }

    @Override
    public Boolean hasCapitalLetter(String psw) {
        return hasCapitalLetter(psw);
    }

    @Override
    public Boolean hasNumber(String psw) {
        return hasDigit(psw);
    }

    public static boolean hasUpperChar(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (!Character.isUpperCase(s.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean hasDigit(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

}
