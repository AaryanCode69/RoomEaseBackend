package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.FirebaseTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirebaseTokenRepository extends JpaRepository<FirebaseTokenEntity, String> {
}