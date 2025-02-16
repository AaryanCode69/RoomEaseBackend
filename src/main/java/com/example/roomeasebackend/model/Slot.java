package com.example.roomeasebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Slot {
    @Id
    @Column(name = "hostel_block")
    private String BLOCK;
    @Column(name="morning")
    private int MORNING;
    @Column(name="afternoon")
    private int AFTERNOON;
    @Column(name="evening")
    private int EVENING;

}
