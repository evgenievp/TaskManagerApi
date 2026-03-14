package com.TaskManagerApi.controller;

import com.TaskManagerApi.dto.ProjectDto;
import com.TaskManagerApi.model.Project;
import com.TaskManagerApi.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto dto) {
        this.projectService.add(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable int id) {
        ProjectDto projectDto = this.projectService.findById(id);
        return ResponseEntity.status(200).body(projectDto);
    }



}
