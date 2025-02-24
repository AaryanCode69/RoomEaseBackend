package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.TimeSlot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AcTicketDTO extends BaseTicketDTO{
    private String description;
    private TimeSlot timeSlot;
}
