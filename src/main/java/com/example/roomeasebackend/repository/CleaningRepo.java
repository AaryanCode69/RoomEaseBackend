package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.Cleaning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningRepo extends JpaRepository<Cleaning, Long> {
}
