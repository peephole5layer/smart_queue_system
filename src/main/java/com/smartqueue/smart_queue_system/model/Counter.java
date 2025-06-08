package com.smartqueue.smart_queue_system.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="counters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Counter {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceType service;
}
