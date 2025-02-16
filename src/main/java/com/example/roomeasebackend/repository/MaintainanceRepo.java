package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.Maintainance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainanceRepo extends JpaRepository<Maintainance, Long> {
}
