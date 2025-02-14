package com.example.roomeasebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "firebase_uid", nullable = false, unique = true)
    private String firebaseUid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name"   )
    private String name;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "hostel_block",nullable = true)
    private String hostelBlock;


}