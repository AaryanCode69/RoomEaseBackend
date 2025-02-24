package com.example.roomeasebackend.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "category")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CleaningTicketDTO.class, name = "CLEANING"),
        @JsonSubTypes.Type(value = ElectricalTicketDTO.class, name = "ELECTRICAL"),
        @JsonSubTypes.Type(value = PlumbingTicketDTO.class, name = "PLUMBING"),
        @JsonSubTypes.Type(value = AcTicketDTO.class, name = "AC")
})
public abstract class BaseTicketDTO {
    private String firebaseUid;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
}