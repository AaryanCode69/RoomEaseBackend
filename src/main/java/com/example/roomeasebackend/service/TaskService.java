package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.Cleaning;
import com.example.roomeasebackend.model.Maintainance;
import com.example.roomeasebackend.model.Status;
import com.example.roomeasebackend.model.User;
import com.example.roomeasebackend.repository.CleaningRepo;
import com.example.roomeasebackend.repository.MaintainanceRepo;
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

    @Autowired
    MaintainanceRepo maintainanceRepo;

    public void createTask(LocalTime time_slot, User user) {
        cleaning.setTimeslot(time_slot);
        cleaning.setUser(user);
        taskRepo.save(cleaning);
    }

    public void createMaintenanceTask(Maintainance maintainance, User user) {
        maintainance.setUser(user);
        maintainanceRepo.save(maintainance);
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

    public void closeMaintenanceTask(Long taskId) {
        Optional<Maintainance> taskOptional = maintainanceRepo.findById(taskId);
        if (taskOptional.isPresent()) {
            Maintainance task = taskOptional.get();
            task.setStatus(Status.COMPLETED);
            maintainanceRepo.save(task);
        } else {
            System.out.println("Task not found");
        }
    }
}
