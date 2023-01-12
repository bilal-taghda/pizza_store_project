package com.project.pizza.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum OrderType {
    VEGGIEPIZZA("VEGGIEPIZZA"), MARGHERITAPIZZA("MARGHERITAPIZZA"), CHEEZEPIZZA("CHEEZEPIZZA");
    public String type;

    OrderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
