package com.example.roomeasebackend.service;

import com.example.roomeasebackend.model.*;
import com.example.roomeasebackend.repository.CleaningRepo;
import com.example.roomeasebackend.repository.MaintainanceRepo;
import com.example.roomeasebackend.repository.WardenRepo;
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

    @Autowired
    private Slot slot;

    @Autowired
    private WardenRepo wardenRepo;

    public void createTask(String time_slot, User user) {
        String Block = user.getHostelBlock();
        Hostel_Type Blocktype = user.getHostel_type();
        slot = wardenRepo.findByBLOCKAndBLOCKTYPE(Block,Blocktype);
        if (time_slot.equals("morning")) {
            slot.setMORNING(slot.getMORNING() - 1);
        } else if (time_slot.equals("afternoon")) {
            slot.setAFTERNOON(slot.getAFTERNOON() - 1);
        } else if (time_slot.equals("evening")) {
            slot.setEVENING(slot.getEVENING() - 1);
        }
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
