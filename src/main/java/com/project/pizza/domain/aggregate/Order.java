package com.project.pizza.domain.aggregate;


import com.project.pizza.domain.entity.*;
import com.project.pizza.domain.valueObject.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated
    private OrderType type;
    @Enumerated
    private OrderStatus status;
    private Long price;
    private String email;

}
