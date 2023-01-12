package com.project.pizza.web;


import com.project.pizza.application.UserAppService;
import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.command.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // Marks the class a rest controller
@RequestMapping("/api/user") // Requests made to /api/auth/anything will be handles by this class
public class UserController {

    @Autowired private UserAppService userAppService;

    @PostMapping("/register")
    public Map<String, String> login(@RequestBody LoginCommand loginCommand){
        return userAppService.login(loginCommand);

    }

    @GetMapping("/details")
    public User getUserDetails(){
        return userAppService.getUserDetails();

    }


}
