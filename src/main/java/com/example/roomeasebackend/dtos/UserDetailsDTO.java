package com.example.roomeasebackend.dtos;

import com.example.roomeasebackend.model.HostelType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {
    private String uid;
    private String phoneNumber;
    private HostelType hostelType;
    private String hostelBlock;
    private String roomNumber;
    private String role = "STUDENT";
}