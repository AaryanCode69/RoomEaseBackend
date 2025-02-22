package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Component
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_Id")
    private UUID ticketId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="category", nullable = false)
    private Category category;

    @Column(name = "status", nullable = false)
    private Status status = Status.INCOMPLETED;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="closed_at")
    private LocalDateTime closedAt;

}
