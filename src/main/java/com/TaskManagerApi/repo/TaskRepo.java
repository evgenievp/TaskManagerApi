package com.TaskManagerApi.repo;

import com.TaskManagerApi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {


}
