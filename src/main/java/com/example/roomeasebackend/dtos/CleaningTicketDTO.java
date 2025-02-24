package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.TimeSlot;
import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO for Cleaning tickets
@Data
@EqualsAndHashCode(callSuper = true)
public class CleaningTicketDTO extends BaseTicketDTO {
    private TimeSlot timeSlot;
}
