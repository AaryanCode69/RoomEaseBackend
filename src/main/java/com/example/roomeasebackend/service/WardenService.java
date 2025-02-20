package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.Hostel_Type;
import com.example.roomeasebackend.model.Slot;
import com.example.roomeasebackend.repository.WardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardenService {
    @Autowired
    private WardenRepo wardenRepo;

    public String entry(String block, int morning, int afternoon, int evening, Hostel_Type hostel_type) {
        Slot slot = wardenRepo.findByBLOCKAndBLOCKTYPE(block, hostel_type);
        if(slot == null){
            slot = new Slot();
            slot.setBLOCK(block);
            slot.setBLOCKTYPE(hostel_type);
        }
        slot.setMORNING(morning);
        slot.setAFTERNOON(afternoon);
        slot.setEVENING(evening);
        wardenRepo.save(slot);
        return "Entry added successfully";

    }
}
