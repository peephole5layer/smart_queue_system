package com.smartqueue.smart_queue_system.repository;

import com.smartqueue.smart_queue_system.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    Optional<ServiceType> findByName(String name);

}
