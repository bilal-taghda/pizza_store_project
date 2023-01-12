package com.project.pizza.domain.command;


import com.project.pizza.domain.entity.Address;
import com.project.pizza.domain.entity.Name;
import com.project.pizza.domain.entity.Password;
import com.project.pizza.domain.entity.Role;;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginCommand {
    private String email;
    private String firstname;
    private String lastname;
    private Role role;
    private Long longitude;
    private Long latitude;
    private Password psw;

}
