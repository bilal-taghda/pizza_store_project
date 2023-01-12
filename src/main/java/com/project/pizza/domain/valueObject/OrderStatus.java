package com.project.pizza.domain.valueObject;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum OrderStatus {
    PLACED("PLACED"), COOKED("COOKED"), READY("READY"), DELIVERED("DELIVERED");
    public String name;
    OrderStatus(String status) {
        this.name = status;
    }
    public String getName() {
        return name;
    }

}
