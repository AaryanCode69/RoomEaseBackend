package com.example.roomeasebackend.controller;

import ch.qos.logback.classic.Logger;
import com.example.roomeasebackend.dtos.UserDetailsDTO;
import com.example.roomeasebackend.model.Role;
import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User userRequest) {
        if (userRequest.getFirebaseUid() == null || userRequest.getFirebaseUid().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Firebase UID cannot be null or empty");
        }
        logger.info("Received createUser request: {}", userRequest);
        userService.createOrUpdateUser(userRequest.getFirebaseUid(), userRequest.getPhoneNumber(), userRequest.getRoomNumber(), userRequest.getHostelBlock(), userRequest.getHostelType(), userRequest.getRole());
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping("/io")
    public ResponseEntity<String> updateUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        if (userDetailsDTO.getUid() == null || userDetailsDTO.getUid().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Firebase UID cannot be null or empty");
        }
        logger.info("Received updateUserDetails request: {}", userDetailsDTO);
        userService.createOrUpdateUser(
                userDetailsDTO.getUid(),
                userDetailsDTO.getPhoneNumber(),
                userDetailsDTO.getRoomNumber(),
                userDetailsDTO.getHostelBlock(),
                userDetailsDTO.getHostelType(),
                Role.valueOf(userDetailsDTO.getRole())
        );
        return ResponseEntity.ok("User details updated successfully");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Error processing request", e);
        return ResponseEntity.status(500).body("Internal Server Error");
    }
}