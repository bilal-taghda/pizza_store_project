package com.project.pizza.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Password  {
    private String name;
    public Password(String psw) {
        this.name = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(new SecurePassword().isSecure(name))
            this.name = name;
    }
}
