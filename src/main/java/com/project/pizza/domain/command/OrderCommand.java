package com.project.pizza.domain.command;


import com.project.pizza.domain.entity.OrderType;
import com.project.pizza.domain.valueObject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderCommand {
    private int id;
    private OrderType type;
    private OrderStatus status;
    private Long price;

}
