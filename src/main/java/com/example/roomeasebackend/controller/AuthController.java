package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.service.FirebaseAuthService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private FirebaseAuthService firebaseAuthService;

    @PostMapping("/verifyToken")
    public ResponseEntity<?> verifyToken(@RequestHeader String idToken) {
        try {
            FirebaseToken decodedToken = firebaseAuthService.verifyToken(idToken);

            return ResponseEntity.ok(decodedToken);
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}