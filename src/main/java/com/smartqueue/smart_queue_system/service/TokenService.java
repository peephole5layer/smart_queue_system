package com.smartqueue.smart_queue_system.service;

import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.model.Token;
import com.smartqueue.smart_queue_system.model.User;

import java.util.List;

public interface TokenService {
    Token createToken(User user, ServiceType service);
    List<Token> getWaitingTokens(ServiceType service);
    Token getNextToken(ServiceType service);
}
