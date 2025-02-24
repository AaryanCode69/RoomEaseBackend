package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.PlumbingIssue;
import lombok.Data;
import lombok.EqualsAndHashCode;

// DTO for Plumbing tickets
@Data
@EqualsAndHashCode(callSuper = true)
public class PlumbingTicketDTO extends BaseTicketDTO {
    private PlumbingIssue plumbingIssue;
    private String description;
}
