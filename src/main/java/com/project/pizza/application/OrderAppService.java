package com.project.pizza.application;

import com.project.pizza.domain.aggregate.Order;
import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.command.ChangeOrderStatusCommand;
import com.project.pizza.domain.command.PlaceOrderCommand;
import com.project.pizza.domain.events.PlaceOrderStatusEvent;
import com.project.pizza.domain.service.CouponedOrderPriceCalculatorService;
import com.project.pizza.infrastracture.rdb.OrderRepo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAppService {
    @Autowired private OrderRepo orderRepo;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('WORKER')")
    public void placeOrder(PlaceOrderCommand pc){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var couponedOreder =
                new CouponedOrderPriceCalculatorService()
                        .couponOrder(new Order(
                                0, pc.getType(), pc.getStatus(), pc.getPrice(), user.getEmail()));

       rabbitTemplate.convertAndSend("order-placed.queue"
               , new PlaceOrderStatusEvent(pc.getType(), pc.getStatus()));

        orderRepo.save(couponedOreder);
    }
    @PreAuthorize("hasAuthority('CHEF') or hasAuthority('WORKER') or hasAuthority('DELIVERY')")
    public void updateOrderStatus(ChangeOrderStatusCommand cosc){

        orderRepo.updateOrderStatus(
                cosc.getStatus(),
                cosc.getId());

    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    public List<Order> getUserOrders(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderRepo.findUserOrdersByEmail(user.getEmail()).orElseThrow();
    }

    @PreAuthorize("hasAuthority('CHEF') or hasAuthority('WORKER') or hasAuthority('DELIVERY')")
    public List<Order> getAllOrders(){
        return (List<Order>) orderRepo.findAll();
    }


}
