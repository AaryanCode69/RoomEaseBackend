package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.Hostel_Type;
import com.example.roomeasebackend.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardenRepo extends JpaRepository<Slot, Long> {

    Slot findByBLOCKAndBLOCKTYPE(String block, Hostel_Type blockType);
}
