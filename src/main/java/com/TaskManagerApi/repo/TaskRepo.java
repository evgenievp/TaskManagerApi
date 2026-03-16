package com.TaskManagerApi.repo;

import com.TaskManagerApi.model.Task;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    Optional<Task> findById(int id);
    Optional<Task> findByTitle(String title);
    Page findAll(Pageable pageable);
}
