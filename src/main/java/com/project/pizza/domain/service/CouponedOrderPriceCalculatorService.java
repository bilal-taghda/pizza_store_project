package com.project.pizza.domain.service;

import com.project.pizza.domain.aggregate.Order;
import com.project.pizza.domain.entity.OrderType;

final public class CouponedOrderPriceCalculatorService {
    final public Order couponOrder(Order order) {
        final var price = order.getPrice();
        if(order.getType().equals(OrderType.CHEEZEPIZZA)) order.setPrice(price - price / 10);
        if(order.getType().equals(OrderType.MARGHERITAPIZZA)) order.setPrice(price - price / 15);
        if(order.getType().equals(OrderType.VEGGIEPIZZA)) order.setPrice(price - price / 20);
        return order;
    }
}
