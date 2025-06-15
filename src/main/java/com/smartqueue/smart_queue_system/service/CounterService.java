package com.smartqueue.smart_queue_system.service;

import com.smartqueue.smart_queue_system.model.Counter;
import com.smartqueue.smart_queue_system.model.ServiceType;

import java.util.List;

public interface CounterService {

    List<Counter> getCounterByService(ServiceType service);
}
