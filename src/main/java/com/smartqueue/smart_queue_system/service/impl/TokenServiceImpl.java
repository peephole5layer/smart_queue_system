package com.smartqueue.smart_queue_system.service.impl;

import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.model.Token;
import com.smartqueue.smart_queue_system.model.User;
import com.smartqueue.smart_queue_system.repository.TokenRepository;
import com.smartqueue.smart_queue_system.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Token createToken(User user, ServiceType service){
        String tokenNumber="T" + System.currentTimeMillis();
        Token token= Token.builder()
                .user(user)
                .service(service)
                .tokenNumber(tokenNumber)
                .status("waiting")
                .build();
        return tokenRepository.save(token);
    }

    @Override
    public List<Token> getWaitingTokens(ServiceType service) {
        return tokenRepository.findServiceAndStatus(service, "waiting");
    }

    @Override
    public Token getNextToken(ServiceType service) {
        return tokenRepository.findFirstByServiceAndStatusOrderByIssuedAtAsc(service, "waiting");
    }

}
