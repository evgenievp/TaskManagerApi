package com.TaskManagerApi.repo;

import com.TaskManagerApi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
