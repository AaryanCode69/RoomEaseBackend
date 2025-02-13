package com.example.roomeasebackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FirebaseTokenEntity {

    @Id
    @Column(length = 1024)
    private String idToken;

    @Column(length = 1024)
    private String uid;
}