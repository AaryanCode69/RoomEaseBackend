package com.example.roomeasebackend.controller;


import com.example.roomeasebackend.dtos.*;
import com.example.roomeasebackend.model.Tickets;
import com.example.roomeasebackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody BaseTicketDTO ticketDTO) {
        Tickets task;

        if (ticketDTO instanceof CleaningTicketDTO) {
            task = taskService.createCleaningTask((CleaningTicketDTO) ticketDTO);
        } else if (ticketDTO instanceof ElectricalTicketDTO) {
            task = taskService.createElectricalTask((ElectricalTicketDTO) ticketDTO);
        } else if (ticketDTO instanceof PlumbingTicketDTO) {
            task = taskService.createPlumbingTask((PlumbingTicketDTO) ticketDTO);
        } else if (ticketDTO instanceof AcTicketDTO) {
            task = taskService.createAcTask((AcTicketDTO) ticketDTO);
        } else {
            return ResponseEntity.badRequest().body("Invalid ticket type");
        }

        return ResponseEntity.ok(task);
    }
}
