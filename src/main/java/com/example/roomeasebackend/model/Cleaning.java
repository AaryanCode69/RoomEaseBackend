package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalTime;

@Component
@Entity
@Table(name = "cleaning_tickets")
@Data
public class Cleaning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "time_slot", nullable = false)
    private String timeslot;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.INCOMPLETED;
}