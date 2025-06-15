package com.smartqueue.smart_queue_system.service.impl;

import com.smartqueue.smart_queue_system.model.User;
import com.smartqueue.smart_queue_system.repository.UserRepository;
import com.smartqueue.smart_queue_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
