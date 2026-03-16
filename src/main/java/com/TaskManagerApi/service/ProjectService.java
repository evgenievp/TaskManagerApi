package com.TaskManagerApi.service;

import com.TaskManagerApi.dto.ProjectDto;
import com.TaskManagerApi.model.Project;
import com.TaskManagerApi.repo.ProjectRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public void add(ProjectDto dto) {
        this.projectRepo.save(toProject(dto));
    }

    public Project toProject(ProjectDto dto) {
        return new Project(
            dto.getName(),
            dto.getDescription()
        );
    }

    public ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getName(),
                project.getDescription()
        );
    }

    public ProjectDto findById(int id) {
        Optional<Project> project = this.projectRepo.findById(id);
        if (project.isEmpty()) {
            throw new EntityNotFoundException("not found entity with that id");
        }
        ProjectDto dto = toDto(project.get());
        return dto;
    }
}
