package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.UserRepo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {

    @Autowired
    private UserRepo userRepo;


    public FirebaseToken verifyToken(String idToken) throws FirebaseAuthException {
        FirebaseToken decoded= FirebaseAuth.getInstance().verifyIdToken(idToken);

        User user = userRepo.findByEmail(decoded.getEmail());
        if (user == null) {
            user = new User();
        }
        user.setFirebaseUid(decoded.getUid());
        user.setEmail(decoded.getEmail());
        user.setName(decoded.getName());

        userRepo.save(user);
        return decoded;
    }
}