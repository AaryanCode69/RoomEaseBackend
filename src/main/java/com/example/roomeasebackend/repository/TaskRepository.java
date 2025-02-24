package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Tickets, Long> {
}
