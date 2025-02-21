package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.HostelType;
import com.example.roomeasebackend.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardenRepo extends JpaRepository<Slot, Long> {

    Slot findByBLOCKAndBLOCKTYPE(String block, HostelType blockType);
}
