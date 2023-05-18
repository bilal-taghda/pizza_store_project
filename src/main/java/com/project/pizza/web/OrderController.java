package com.project.pizza.web;


import com.project.pizza.application.OrderAppService;
import com.project.pizza.domain.aggregate.Order;
import com.project.pizza.domain.command.OrderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks the class a rest controller
@RequestMapping("/api/order") // Requests made to /api/auth/anything will be handles by this class
public class OrderController {

    @Autowired private OrderAppService appService;

    @PostMapping("/placeOrder")
    public void placeOrder(@RequestBody OrderCommand poc){
        appService.placeOrder(poc);
    }

    @PutMapping("/updateOrderStatus")
    public void updateOrderStatus(@RequestBody OrderCommand cosc){
        appService.updateOrderStatus(cosc);
    }

    @GetMapping("/userOrders")
    public List<Order> getUserOrders(){
        return appService.getUserOrders();
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        return appService.getAllOrders();
    }


}
