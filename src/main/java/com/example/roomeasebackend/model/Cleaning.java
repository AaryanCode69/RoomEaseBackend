package com.example.roomeasebackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cleaning_tickets")
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

    // Getters and setters
}