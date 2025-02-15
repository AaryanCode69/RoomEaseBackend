package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.UserRepo;
import com.example.roomeasebackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepo repo;

    @PostMapping("/createTask/cleaning")
    public ResponseEntity<?> createTask(@RequestParam("time_slot") String timeSlotStr,@RequestParam String uid) {

        User user = repo.findByfirebaseUid(uid);
        LocalTime timeSlot;
        try {
            timeSlot = LocalTime.parse(timeSlotStr);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid time format. Please use HH:mm:ss format.");
        }

        taskService.createTask(timeSlot,user);
        return ResponseEntity.ok("Task created successfully");
    }
    @PostMapping("/maintenance")
    public ResponseEntity<?> createmaintenanceTask(){

        return ResponseEntity.ok("Task created successfully");
    }
}
