package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.TaskDto;
import com.TaskManagerApi.model.Task;
import com.TaskManagerApi.service.TaskService;
import com.TaskManagerApi.utils.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDto> add(@RequestBody TaskDto dto) {
        this.taskService.saveTask(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable int id) {
        TaskDto task = this.taskService.findById(id);
        this.taskService.delete(task);
        return ResponseEntity.status(200).body(task);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable int id) {
        TaskDto dto = this.taskService.findById(id);
        return ResponseEntity.status(200).body(dto);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id) {
        TaskDto task = this.taskService.findById(id);
        if (task.getStatus().equals(Status.DONE)) {
            return ResponseEntity.status(200).body(task);
        }
        else {
            if (task.getStatus().equals(Status.PROCESSING)) {
                task.setStatus(Status.DONE);
                this.taskService.saveTask(task);
            }
            else {
                task.setStatus(Status.PROCESSING);
                this.taskService.saveTask(task);
            }
        }
        return ResponseEntity.status(200).body(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<Page<TaskDto>> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(taskService.getTasks(page, size));
    }



}
