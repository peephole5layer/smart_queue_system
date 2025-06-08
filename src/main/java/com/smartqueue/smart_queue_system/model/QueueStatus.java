package com.smartqueue.smart_queue_system.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "queue_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueueStatus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "token_id")
    private Token token;

    private String currentStage; // Queued, Skipped, Served etc.
}