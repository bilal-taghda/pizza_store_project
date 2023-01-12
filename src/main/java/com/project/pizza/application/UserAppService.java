package com.project.pizza.application;

import com.project.pizza.application.security.JwtService;
import com.project.pizza.domain.aggregate.User;
import com.project.pizza.domain.command.LoginCommand;
import com.project.pizza.domain.entity.Address;
import com.project.pizza.domain.entity.Name;
import com.project.pizza.domain.entity.Password;
import com.project.pizza.infrastracture.rdb.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UserAppService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtService jwtService;
    public Map<String, String> login(LoginCommand loginCommand){

        String encodedPassword = passwordEncoder
                .encode(loginCommand.getPsw().getName());

        loginCommand.setPsw(new Password(encodedPassword));

        var user = new User(loginCommand.getEmail()
                , new Name(loginCommand.getFirstname(), loginCommand.getLastname())
                , loginCommand.getRole()
                , new Address(loginCommand.getLongitude(), loginCommand.getLatitude())
                , loginCommand.getPsw());
        userRepo.save(user);

        String token = jwtService.generateToken(user);

        // Responding with JWT
        return Collections.singletonMap("jwt-token", token);

    }

    public User getUserDetails(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepo.findUserByEmail(user.getEmail()).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findUserByEmail(email).orElseThrow();
    }

}
