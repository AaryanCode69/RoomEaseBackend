package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.HostelType;
import com.example.roomeasebackend.model.Role;
import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void createOrUpdateUser(String uid, String phone, String room, String hostel, HostelType hostelType, Role role) {
        if (uid == null || uid.trim().isEmpty()) {
            throw new IllegalArgumentException("Firebase UID cannot be null or empty");
        }

        User user = Optional.ofNullable(userRepo.findByFirebaseUid(uid))
                            .orElseGet(User::new);
        user.setFirebaseUid(uid);
        user.setPhoneNumber(phone);
        user.setRoomNumber(room);
        user.setHostelBlock(hostel);
        user.setHostelType(hostelType);
        user.setRole(role);
        userRepo.save(user);
    }
}