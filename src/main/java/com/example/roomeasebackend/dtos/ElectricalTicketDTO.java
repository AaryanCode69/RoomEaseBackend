package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.ElectricalIssue;
import com.example.roomeasebackend.model.TimeSlot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ElectricalTicketDTO extends BaseTicketDTO {
    private String description;
    private ElectricalIssue electricalIssue;
    private TimeSlot timeSlot;
}
