package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.dtos.WardenEntryDTO;
import com.example.roomeasebackend.model.HostelType;
import com.example.roomeasebackend.service.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WardenController {
    @Autowired
    private WardenService wardenService;

    @PutMapping("/entry")
    public String entry(@RequestBody WardenEntryDTO entryRequest) {
        // Call the wardenService's entry method with the details from the WardenEntryDTO
        return wardenService.entry(entryRequest.getBlock(), entryRequest.getMorning(), entryRequest.getAfternoon(), entryRequest.getEvening(), entryRequest.getHostelType());
    }
}
