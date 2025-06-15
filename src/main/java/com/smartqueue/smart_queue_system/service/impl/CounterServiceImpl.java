package com.smartqueue.smart_queue_system.service.impl;

import com.smartqueue.smart_queue_system.model.Counter;
import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.repository.CounterRepository;
import com.smartqueue.smart_queue_system.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterServiceImpl  implements CounterService {

    @Autowired
    private CounterRepository counterRepository;

    @Override
    public List<Counter> getCounterByService(ServiceType service) {
        return counterRepository.findByService(service);
    }
}
