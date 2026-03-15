package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.TaskDto;
import com.TaskManagerApi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService taskService;

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

}
