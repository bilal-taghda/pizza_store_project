package com.project.pizza.domain.command;


import com.project.pizza.domain.valueObject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChangeOrderStatusCommand {
    private int id;
    private OrderStatus status;
}
