package com.project.pizza.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum Role {
    CUSTOMER("CUSTOMER"),WORKER("WORKER"),CHEF("CHEF"),DELIVERY("DELIVERY");
    public String name;

    Role(String role) {
        this.name = role;
    }

    public String getName() {
        return name;
    }
}
