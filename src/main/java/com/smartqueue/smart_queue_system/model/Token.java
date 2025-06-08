package com.smartqueue.smart_queue_system.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tokenNumber; // e.g. A101, B202

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceType service;

    @ManyToOne
    @JoinColumn(name = "counter_id")
    private Counter counter;

    private String status; // WAITING, SERVING, DONE, CANCELLED

    private LocalDateTime issuedAt;

    private LocalDateTime servedAt;
}