package com.alm02eliasmjessieejohannessdanielh.portfolio.service;

import com.alm02eliasmjessieejohannessdanielh.portfolio.api.repository.ProjectRepository;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Transactional
    public Project addProject(Project project) {
        return repository.save(project);

    }

    @Transactional
    public Project deleteProject(UUID projectId) {
        Project projectById = repository.findById(projectId)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,
                        "Could not delete non-existing project by id"));
        repository.delete(projectById);
        return projectById;
    }
}
