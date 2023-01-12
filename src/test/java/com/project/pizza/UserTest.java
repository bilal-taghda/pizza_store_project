package com.project.pizza;

import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.entity.Address;
import com.project.pizza.domain.entity.Name;
import com.project.pizza.domain.entity.Password;
import com.project.pizza.domain.entity.Role;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    private User user;
    @BeforeAll
    public void set_up(){
        user = new User("email", new Name("bilal", "taghda")
                , Role.CHEF,new Address(0l, 0l), new Password("Password123") );
    }
    @Test
    @DisplayName("check password exist")
    public void psw_existed(){
        assert user.getPsw().getName().equals("Password123");
    }
    @Test
    @DisplayName("check password hasUpperChar")
    public void psw_hasUpperChar(){
        assert hasUpperChar(user.getPsw().getName());
    }
    @Test
    @DisplayName("check password hasDigit")
    public void psw_hasDigit(){
        Assertions.assertTrue(hasDigit(user.getPsw().getName()));
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
