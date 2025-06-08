package com.smartqueue.smart_queue_system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

}

