package com.project.pizza.application;

import com.project.pizza.domain.aggregate.Order;
import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.command.OrderCommand;
import com.project.pizza.domain.service.CouponedOrderPriceCalculatorService;
import com.project.pizza.infrastracture.db.OrderRepo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class OrderAppService {
    @Autowired private OrderRepo orderRepo;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @PreAuthorize("hasAuthority('CUSTOMER') or hasAuthority('WORKER')")
    public void placeOrder(OrderCommand pc){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var couponedOreder =
                new CouponedOrderPriceCalculatorService()
                        .couponOrder(new Order(
                                new Random().nextInt()
                                , pc.getType(), pc.getStatus(), pc.getPrice(), user.getEmail()));

       //rabbitTemplate.convertAndSend("order-placed.queue", new PlaceOrderStatusEvent(pc.getType(), pc.getStatus()));

        orderRepo.save(couponedOreder);
    }
    @PreAuthorize("hasAuthority('CHEF') or hasAuthority('WORKER') or hasAuthority('DELIVERY')")
    public void updateOrderStatus(OrderCommand pc){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var order = new Order(  pc.getId(), pc.getType(), pc.getStatus(), pc.getPrice(), user.getEmail());
        orderRepo.save(order);

    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    public List<Order> getUserOrders(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderRepo.findByEmail(user.getEmail()).orElseThrow();
    }

    @PreAuthorize("hasAuthority('CHEF') or hasAuthority('WORKER') or hasAuthority('DELIVERY')")
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }


}
