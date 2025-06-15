package com.smartqueue.smart_queue_system.controller;

import com.smartqueue.smart_queue_system.model.User;
import com.smartqueue.smart_queue_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Optional<User> dbUser=userService.findByEmail(user.getEmail());
        if(dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }

    }
}
