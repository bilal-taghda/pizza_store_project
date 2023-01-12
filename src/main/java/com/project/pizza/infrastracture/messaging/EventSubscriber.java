package com.project.pizza.infrastracture.messaging;

import com.project.pizza.domain.events.PlaceOrderStatusEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
@RabbitListener(queues = "order-placed.queue", id = "listener")
public class EventSubscriber {


    @RabbitHandler
    public void orderCookedEvent(PlaceOrderStatusEvent cose) {
        log.info(cose.toString());
    }
}
