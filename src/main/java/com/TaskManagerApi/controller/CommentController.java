package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.CommentDto;
import com.TaskManagerApi.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto dto) {
        this.commentService.save(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @PostMapping("/delete")
    public ResponseEntity<CommentDto> deleteComment(@RequestBody CommentDto dto) {
        this.commentService.delete(dto);
        return ResponseEntity.status(200).body(dto);
    }


}
