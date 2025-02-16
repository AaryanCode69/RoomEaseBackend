package com.example.roomeasebackend.repository;

import com.example.roomeasebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByfirebaseUid(String firebaseUid);
}
