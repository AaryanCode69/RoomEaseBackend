package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.HostelType;
import lombok.Data;

@Data
public class WardenEntryDTO {
    private String block;
    private int morning;
    private int afternoon;
    private int evening;
    private HostelType hostelType;
}
