package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("PLUMBING")
@Table(name = "plumbing_ticket")
public class PlumbingTicket extends Tickets {

    @Column(name = "plumbing_issue", nullable = false)
    private PlumbingIssue plumbingIssue;

    @Column(name = "description")
    private String description;
}
