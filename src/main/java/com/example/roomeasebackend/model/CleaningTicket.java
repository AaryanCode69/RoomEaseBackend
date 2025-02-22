package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("CLEANING")
@Table(name = "cleaning_ticket")
public class CleaningTicket extends Tickets {
    @Enumerated(EnumType.STRING)
    @Column(name = "time_slot", nullable = false)
    private TimeSlot timeSlot;
}