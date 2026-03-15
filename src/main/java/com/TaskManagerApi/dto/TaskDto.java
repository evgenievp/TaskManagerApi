package com.TaskManagerApi.dto;


import com.TaskManagerApi.model.User;
import com.TaskManagerApi.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
        private String title;
        private Status status;
        private LocalDateTime createdAt;
        private User author;
        private List<CommentDto> comments = new LinkedList<>();

        public void addComment(CommentDto comment) {
            this.comments.add(comment);
        }

    public TaskDto(String title, User author, Status status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }
}
