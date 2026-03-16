package com.TaskManagerApi.repo;

import com.TaskManagerApi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
