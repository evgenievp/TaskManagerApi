package com.TaskManagerApi.service;

import com.TaskManagerApi.dto.CommentDto;
import com.TaskManagerApi.dto.TaskDto;
import com.TaskManagerApi.model.Task;
import com.TaskManagerApi.repo.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    private Task toTask(TaskDto dto) {
        return new Task(
                dto.getTitle(),
                dto.getAuthor(),
                dto.getStatus()
        );
    }

    public void delete(TaskDto dto) {
        Optional<Task> task = this.taskRepo.findByTitle(dto.getTitle());
        if (task.isEmpty()) {
            throw new EntityNotFoundException("no such entity in db");
        }
        this.taskRepo.delete(task.get());
    }


    public TaskDto findById(int id) {
        Optional<Task> task = this.taskRepo.findById(id);
        if (task.isEmpty()) {
            throw new EntityNotFoundException("not such entity in db");
        }
        return toDto(task.get());
    }

    private TaskDto toDto(Task task) {
        return new TaskDto(
                task.getTitle(),
                task.getAuthor(),
                task.getStatus()
        );
    }

    public void saveTask(TaskDto taskDto) {
        this.taskRepo.save(toTask(taskDto));
    }
}
