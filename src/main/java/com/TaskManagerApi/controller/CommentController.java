package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.CommentDto;
import com.TaskManagerApi.dto.TaskDto;
import com.TaskManagerApi.service.CommentService;
import com.TaskManagerApi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class CommentController {
    private CommentService commentService;
    private TaskService taskService;

    public CommentController(CommentService commentService, TaskService taskService) {
        this.commentService = commentService;
        this.taskService = taskService;
    }

    @PostMapping("/post/{taskId}/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto dto,
                                                 @PathVariable int taskId) {
        TaskDto taskDto = this.taskService.findById(taskId);
        taskDto.addComment(dto);
        this.taskService.saveTask(taskDto);
        this.commentService.save(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @PostMapping("/delete/comments/{id}")
    public ResponseEntity<CommentDto> deleteComment(@PathVariable int id) {
        CommentDto commentDto = this.commentService.findById(id);
        this.commentService.delete(commentDto);
        return ResponseEntity.status(200).body(commentDto);
    }


}
