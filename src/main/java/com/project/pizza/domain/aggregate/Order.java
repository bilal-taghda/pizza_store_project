package com.project.pizza.domain.aggregate;


import com.project.pizza.domain.entity.*;
import com.project.pizza.domain.valueObject.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Order {
    @Id
    private int id;
    @Enumerated
    private OrderType type;
    @Enumerated
    private OrderStatus status;
    private Long price;
    private String email;

}
