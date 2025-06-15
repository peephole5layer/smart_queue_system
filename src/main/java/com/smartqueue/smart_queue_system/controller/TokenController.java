package com.smartqueue.smart_queue_system.controller;

import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.model.Token;
import com.smartqueue.smart_queue_system.model.User;
import com.smartqueue.smart_queue_system.service.ServiceTypeService;
import com.smartqueue.smart_queue_system.service.TokenService;
import com.smartqueue.smart_queue_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping("/book")
    public Token bookToken(@RequestParam Long userId, @RequestParam Long serviceId) {
        User user = userService.findByEmail("dummy@mail.com").orElseThrow(); // use actual user fetching logic
        ServiceType service = serviceTypeService.getById(serviceId);
        return tokenService.createToken(user, service);
    }

    @GetMapping("/waiting")
    public List<Token> getWaitingTokens(@RequestParam Long serviceId) {
        ServiceType service = serviceTypeService.getById(serviceId);
        return tokenService.getWaitingTokens(service);
    }
}
