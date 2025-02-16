package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.Slot;
import com.example.roomeasebackend.repository.WardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardenService {
    @Autowired
    private WardenRepo wardenRepo;

    public String entry(String block, int morning, int afternoon, int evening) {
        Slot slot = new Slot();
        slot.setBLOCK(block);
        slot.setMORNING(morning);
        slot.setAFTERNOON(afternoon);
        slot.setEVENING(evening);
        wardenRepo.save(slot);
        return "Entry added successfully";

    }
}
