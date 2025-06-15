package com.smartqueue.smart_queue_system.repository;

import com.smartqueue.smart_queue_system.model.Counter;
import com.smartqueue.smart_queue_system.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterRepository extends JpaRepository<Counter,Long> {
    List<Counter> findByService(ServiceType service);
}
