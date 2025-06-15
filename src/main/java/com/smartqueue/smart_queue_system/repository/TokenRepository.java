package com.smartqueue.smart_queue_system.repository;

import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.model.Token;
import com.smartqueue.smart_queue_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokenRepository extends JpaRepository<Token,Long> {
    List<Token> findServiceAndStatus(ServiceType service, String status);
    List<Token> findUser(User user);
    Token findFirstByServiceAndStatusOrderByIssuedAtAsc(ServiceType service, String status);

}
