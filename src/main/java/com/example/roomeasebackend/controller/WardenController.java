package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.model.HostelType;
import com.example.roomeasebackend.service.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WardenController {
    @Autowired
    private WardenService wardenService;

    @PutMapping("/entry")
    public String entry(@RequestParam String Block, @RequestParam int morning, @RequestParam int afternoon, @RequestParam int evening, @RequestParam HostelType hostel_type) {
        return wardenService.entry(Block,morning,afternoon,evening,hostel_type);
    }
}
