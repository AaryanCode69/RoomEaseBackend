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
    private UserRepo userRepo;

    @Autowired
    private WardenService wardenService;

    public Tickets createCleaningTask(CleaningTicketDTO dto) {
        Tickets tickets=taskRepository.findByUserAndStatusAndCategory(userRepo.findByFirebaseUid(dto.getFirebaseUid()), Status.PENDING, CleaningTicket.class);
        if(tickets!=null){
            throw new RuntimeException("Task already exists");
        }
        User user = userRepo.findByFirebaseUid(dto.getFirebaseUid());

        boolean slotAvailable = wardenService.updateSlotAvailability(
                user.getHostelBlock(),
                dto.getTimeSlot().toString(),
                user.getHostelType(),
                false
        );

        if (!slotAvailable) {
            throw new RuntimeException("No slots available for selected time");
        }

        CleaningTicket task = new CleaningTicket();
        setBaseFields(task, dto);
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    public Tickets createElectricalTask(ElectricalTicketDTO dto) {
        Tickets tickets=taskRepository.findByUserAndStatusAndCategory(userRepo.findByFirebaseUid(dto.getFirebaseUid()), Status.PENDING, ElectricalTicket.class);
        if(tickets!=null){
            throw new RuntimeException("Task already exists");
        }
        ElectricalTicket task = new ElectricalTicket();
        setBaseFields(task, dto);
        task.setElectricalIssue(dto.getElectricalIssue());
        task.setDescription(dto.getDescription());
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    public Tickets createPlumbingTask(PlumbingTicketDTO dto) {
        Tickets tickets=taskRepository.findByUserAndStatusAndCategory(userRepo.findByFirebaseUid(dto.getFirebaseUid()), Status.PENDING, PlumbingTicket.class);
        if(tickets!=null){
            throw new RuntimeException("Task already exists");
        }
        PlumbingTicket task = new PlumbingTicket();
        setBaseFields(task, dto);
        task.setPlumbingIssue(dto.getPlumbingIssue());
        task.setDescription(dto.getDescription());
        return taskRepository.save(task);
    }

    public Tickets createAcTask(AcTicketDTO dto) {
        Tickets tickets=taskRepository.findByUserAndStatusAndCategory(userRepo.findByFirebaseUid(dto.getFirebaseUid()), Status.PENDING, AcTicket.class);
        if(tickets!=null){
            throw new RuntimeException("Task already exists");
        }
        AcTicket task = new AcTicket();
        setBaseFields(task, dto);
        task.setDescription(dto.getDescription());
        task.setTimeSlot(dto.getTimeSlot());
        return taskRepository.save(task);
    }

    private void setBaseFields(Tickets task, BaseTicketDTO dto) {
        User user = userRepo.findByFirebaseUid(dto.getFirebaseUid());
        task.setUser(user);
        task.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now());
        task.setClosedAt(dto.getClosedAt());
    }

//we can cannot find task by category directly since it is discriminatory column
// so have to run manual query in repo by finding the class of that category and passing that class
    public Tickets closeTask(String firebaseUid, String category) {
        Class<? extends Tickets> categoryClass = switch (category.toUpperCase()) {
            case "CLEANING" -> CleaningTicket.class;
            case "ELECTRICAL" -> ElectricalTicket.class;
            case "PLUMBING" -> PlumbingTicket.class;
            case "AC" -> AcTicket.class;
            default -> throw new IllegalArgumentException("Invalid category: " + category);
        };
        User user = userRepo.findByFirebaseUid(firebaseUid);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Tickets task = taskRepository.findByUserAndStatusAndCategory(user, Status.PENDING, categoryClass);
        if (task == null) {
            throw new RuntimeException("Task not found or already completed");
        }
        task.setStatus(Status.COMPLETED);
        task.setClosedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }
}