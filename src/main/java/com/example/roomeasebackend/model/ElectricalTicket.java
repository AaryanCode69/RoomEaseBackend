package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("ELECTRICAL")
@Table(name = "electrical_ticket")
public class ElectricalTicket extends Tickets {
    @Enumerated(EnumType.STRING)
    @Column(name = "electrical_issue", nullable = false)
    private ElectricalIssue electricalIssue;

    @Column(name = "description")
    private String description;

    @Column(name= "time_slot")
    private TimeSlot timeSlot;
}
