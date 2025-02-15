package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(String uid,String phone, String room, String hostel){
        User user = userRepo.findByfirebaseUid(uid);
        if (user == null) {
            // Handle the case where the user is not found
            throw new IllegalArgumentException("User not found with uid: " + uid);
        }
        user.setRoomNo(room);
        user.setPhoneNumber(phone);
        user.setHostelBlock(hostel);
        userRepo.save(user);
    }
}
