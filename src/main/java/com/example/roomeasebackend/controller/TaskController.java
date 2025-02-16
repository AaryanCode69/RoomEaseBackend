package com.example.roomeasebackend.controller;

import com.example.roomeasebackend.model.Maintainance;
import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.MaintainanceRepo;
import com.example.roomeasebackend.repository.UserRepo;
import com.example.roomeasebackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        taskService.createTask(timeSlotStr,user);
        return ResponseEntity.ok("Task created successfully");
    }

    @PostMapping("/maintenance")
    public ResponseEntity<?> createmaintenanceTask(@RequestBody  Maintainance maintainance,@RequestParam String uid) {
        User user = repo.findByfirebaseUid(uid);
        taskService.createMaintenanceTask(maintainance,user);
        return ResponseEntity.ok("Task created successfully");
    }

    @PostMapping("/closeCleaningTicket")
    public ResponseEntity<?> closeTicket(@RequestParam Long taskId){
        taskService.closeTask(taskId);
        return ResponseEntity.ok("Task closed successfully");
        }
    @PostMapping("/closeMaintenanceTicket")
    public ResponseEntity<?> closeMaintenanceTicket(@RequestParam Long taskId){
        taskService.closeMaintenanceTask(taskId);
        return ResponseEntity.ok("Task closed successfully");
    }
}
