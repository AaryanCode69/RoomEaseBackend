package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.*;
import com.example.roomeasebackend.repository.WardenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TaskService {





    @Autowired
    private Slot slot;

    @Autowired
    private WardenRepo wardenRepo;




}