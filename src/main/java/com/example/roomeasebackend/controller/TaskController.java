package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.UserRepo;
import com.example.roomeasebackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepo repo;









}
