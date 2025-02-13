package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.FirebaseTokenEntity;
import com.example.roomeasebackend.repository.FirebaseTokenRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {

    @Autowired
    private FirebaseTokenRepository firebaseTokenRepository;

    public FirebaseToken verifyToken(String idToken) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().verifyIdToken(idToken);
    }

    public void storeToken(String idToken, FirebaseToken firebaseToken) {
        FirebaseTokenEntity tokenEntity = new FirebaseTokenEntity();
        tokenEntity.setIdToken(idToken);
        tokenEntity.setUid(firebaseToken.getUid());
        firebaseTokenRepository.save(tokenEntity);
    }
}
