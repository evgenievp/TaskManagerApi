package com.TaskManagerApi.model;

import com.TaskManagerApi.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String title;
    private Status status;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments = new LinkedList<>();

    public Task(String title, Status status, User author) {
        this.title = title;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.author = author;
    }

    public Task(String title, User author, Status status) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }
}
