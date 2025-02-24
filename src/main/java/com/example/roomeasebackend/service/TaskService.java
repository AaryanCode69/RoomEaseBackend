package com.example.roomeasebackend.service;

import com.example.roomeasebackend.dtos.*;
import com.example.roomeasebackend.model.*;
import com.example.roomeasebackend.repository.TaskRepository;
import com.example.roomeasebackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepo UserRepo;

    public Tickets createCleaningTask(CleaningTicketDTO dto) {
        CleaningTicket task = new CleaningTicket();
        setBaseFields(task, dto);
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    public Tickets createElectricalTask(ElectricalTicketDTO dto) {
        ElectricalTicket task = new ElectricalTicket();
        setBaseFields(task, dto);
        task.setElectricalIssue(dto.getElectricalIssue());
        task.setDescription(dto.getDescription());
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    public Tickets createPlumbingTask(PlumbingTicketDTO dto) {
        PlumbingTicket task = new PlumbingTicket();
        setBaseFields(task, dto);
        task.setPlumbingIssue(dto.getPlumbingIssue());
        task.setDescription(dto.getDescription());
        return taskRepository.save(task);
    }

    public Tickets createAcTask(AcTicketDTO dto) {
        AcTicket task = new AcTicket();
        setBaseFields(task, dto);
        task.setDescription(dto.getDescription());
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    private void setBaseFields(Tickets task, BaseTicketDTO dto) {
        User user = UserRepo.findByFirebaseUid(dto.getFirebaseUid());
        task.setUser(user);
        task.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now());
        task.setClosedAt(dto.getClosedAt());
    }
}