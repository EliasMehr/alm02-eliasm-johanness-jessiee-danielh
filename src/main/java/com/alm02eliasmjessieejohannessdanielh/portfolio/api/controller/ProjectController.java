package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import com.alm02eliasmjessieejohannessdanielh.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v2/")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project) {
        Project addedProject = projectService.addProject(project);
        return ResponseEntity.ok(addedProject);
    }

    @DeleteMapping("projects/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable UUID id) {
        Project project = projectService.deleteProject(id);
        return ResponseEntity.accepted().body(project);
    }

}
