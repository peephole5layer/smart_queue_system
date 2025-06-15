package com.smartqueue.smart_queue_system.service;

import com.smartqueue.smart_queue_system.model.User;

import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByEmail(String email);
}
