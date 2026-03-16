package com.TaskManagerApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @NotNull
    private String text;
    private LocalDateTime createdAt;
    @ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
    @JoinColumn(name= "task_id")
    private Task task;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(String text) {
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }

    public Comment(String text, User user, Task task) {
        this.text = text;
        this.user = user;
        this.task = task;
    }

    public Comment(String text, int id) {
        this.text = text;
        this.id = id;
    }
}
