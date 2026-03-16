package com.TaskManagerApi.service;

import com.TaskManagerApi.dto.CommentDto;
import com.TaskManagerApi.model.Comment;
import com.TaskManagerApi.repo.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }


    public void save(CommentDto dto) {
        this.commentRepo.save(toComment(dto));
    }

    public void delete(CommentDto dto) {
        this.commentRepo.delete(toComment(dto));
    }

    public CommentDto editComment(CommentDto dto) {
        CommentDto newDto = new CommentDto(
                dto.getText(),
                dto.getTaskId()
        );
        this.commentRepo.save(toComment(newDto));
        return newDto;
    }

    public CommentDto findById(int id) {
        return null;
    }

    public CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getText(),
                comment.getId());
    }

    public Comment toComment(CommentDto dto) {
        return new Comment(
                dto.getText(),
                dto.getTaskId());
    }
}
