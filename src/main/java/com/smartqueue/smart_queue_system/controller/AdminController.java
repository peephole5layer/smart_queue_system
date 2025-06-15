package com.smartqueue.smart_queue_system.controller;


import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.model.Token;
import com.smartqueue.smart_queue_system.service.ServiceTypeService;
import com.smartqueue.smart_queue_system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @PostMapping("/next")
    public Token serveNext(@RequestParam Long serviceId) {
        ServiceType service = serviceTypeService.getById(serviceId);
        Token next = tokenService.getNextToken(service);
        if (next != null) {
            next.setStatus("SERVED");
            return tokenService.createToken(next.getUser(), service); // or update token
        } else {
            throw new RuntimeException("No token in queue!");
        }
    }
}