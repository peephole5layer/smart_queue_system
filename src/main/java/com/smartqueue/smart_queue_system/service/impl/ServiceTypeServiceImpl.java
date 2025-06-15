package com.smartqueue.smart_queue_system.service.impl;

import com.smartqueue.smart_queue_system.model.ServiceType;
import com.smartqueue.smart_queue_system.repository.ServiceTypeRepository;
import com.smartqueue.smart_queue_system.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public ServiceType getById(Long id) {
        return serviceTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceType not found with id: " + id));
    }
}
