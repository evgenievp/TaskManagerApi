package com.TaskManagerApi.repo;

import com.TaskManagerApi.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    Optional<Task> findById(int id);
    Optional<Task> findByTitle(String title);
    Page<Task> findAll(Pageable pageable);
}
