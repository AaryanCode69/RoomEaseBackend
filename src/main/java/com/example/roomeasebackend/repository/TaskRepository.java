package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.Status;
import com.example.roomeasebackend.model.Tickets;
import com.example.roomeasebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<Tickets, Long> {

    @Query("SELECT t FROM Tickets t WHERE t.user = :user AND t.status = :status AND TYPE(t) = :category")
    Tickets findByUserAndStatusAndCategory(@Param("user") User user, @Param("status") Status status, @Param("category") Class<? extends Tickets> category);
}