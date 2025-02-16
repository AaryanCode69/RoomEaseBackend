package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.Cleaning;
import com.example.roomeasebackend.model.Status;
import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.CleaningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    CleaningRepo taskRepo;

    @Autowired
    Cleaning cleaning;

    public void createTask(LocalTime time_slot, User user) {
        cleaning.setTimeslot(time_slot);
        cleaning.setUser(user);
        taskRepo.save(cleaning);
    }

    public void createMaintenanceTask() {
        System.out.println("Task created successfully");
    }

    public void closeTask(Long taskId) {
        Optional<Cleaning> taskOptional = taskRepo.findById(taskId);
        if (taskOptional.isPresent()) {
            Cleaning task = taskOptional.get();
            task.setStatus(Status.COMPLETED);
            taskRepo.save(task);
        } else {
            System.out.println("Task not found");
        }
    }
}