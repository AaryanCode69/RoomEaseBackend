package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.HostelType;
import com.example.roomeasebackend.model.Slot;
import com.example.roomeasebackend.repository.WardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardenService {
    @Autowired
    private WardenRepo wardenRepo;

    public String entry(String block, int morning, int afternoon, int evening, HostelType hostel_type) {
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

    /**
     * Updates the slot availability for a given block, time slot, and hostel type.
     *
     * @param block The hostel block identifier
     * @param timeSlot The time slot (MORNING/AFTERNOON/EVENING)
     * @param hostelType The type of hostel (BOYS/GIRLS)
     * @param increment True to increase slots, False to decrease slots
     * @return True if slot update successful, False if no slots available
     */
    public boolean updateSlotAvailability(String block, String timeSlot, HostelType hostelType, boolean increment) {
        // Find existing slot configuration for the block and hostel type
        Slot slot = wardenRepo.findByBLOCKAndBLOCKTYPE(block, hostelType);
        if (slot == null) {
            throw new RuntimeException("No slots configured for this block");
        }

        int availableSlots;
        // Handle different time slots
        switch (timeSlot.toUpperCase()) {
            case "MORNING":
                availableSlots = slot.getMORNING();
                // Check if slots available when decrementing
                if (!increment && availableSlots <= 0) return false;
                // Update morning slot count
                slot.setMORNING(increment ? availableSlots + 1 : availableSlots - 1);
                break;
            case "AFTERNOON":
                availableSlots = slot.getAFTERNOON();
                if (!increment && availableSlots <= 0) return false;
                // Update afternoon slot count
                slot.setAFTERNOON(increment ? availableSlots + 1 : availableSlots - 1);
                break;
            case "EVENING":
                availableSlots = slot.getEVENING();
                if (!increment && availableSlots <= 0) return false;
                // Update evening slot count
                slot.setEVENING(increment ? availableSlots + 1 : availableSlots - 1);
                break;
            default:
                throw new RuntimeException("Invalid time slot");
        }

        // Save updated slot configuration
        wardenRepo.save(slot);
        return true;
    }
}
