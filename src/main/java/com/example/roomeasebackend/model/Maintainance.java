package com.example.roomeasebackend.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="maintainance_table")
public class Maintainance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintainance_id")
    private Long maintenanceId;

    @Column(name = "issue", nullable = false)
    private String issue;

    @Column(name = "issue_type", nullable = false)
    private String issueType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.INCOMPLETED;

}