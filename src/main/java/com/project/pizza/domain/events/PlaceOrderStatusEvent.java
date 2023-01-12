package com.project.pizza.domain.events;


import com.project.pizza.domain.entity.OrderType;
import com.project.pizza.domain.valueObject.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@Getter
public class PlaceOrderStatusEvent extends Event {
    private OrderType orderType;
    private OrderStatus orderStatus;
    private String eventVersion;
    private Instant when;

    public PlaceOrderStatusEvent(OrderType orderType, OrderStatus orderStatus) {
        super();
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.eventVersion = eventVersion();
        this.when = when();
    }

    @Override
    public String toString() {
        return "PlaceOrderStatusEvent{" +
                "orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                ", eventVersion='" + eventVersion + '\'' +
                ", when=" + when +
                '}';
    }
}
