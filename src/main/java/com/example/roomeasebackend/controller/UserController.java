package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User userRequest) {


        userService.createUser(userRequest.getFirebaseUid(),userRequest.getPhoneNumber(),userRequest.getRoomNo(), userRequest.getHostelBlock());

        return ResponseEntity.ok("User created successfully");
    }
}
