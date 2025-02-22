package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("AC")
@Table(name = "ac_ticket")
public class AcTicket extends Tickets {
    @Column(name="time_slot")
    private TimeSlot timeSlot;

    @Column(name = "description")
    private String description;
}
