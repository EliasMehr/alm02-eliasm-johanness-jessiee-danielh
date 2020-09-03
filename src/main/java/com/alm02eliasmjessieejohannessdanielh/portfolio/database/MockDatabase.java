package com.alm02eliasmjessieejohannessdanielh.portfolio.database;

import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockDatabase {

    private List<Project> projectList;

    public MockDatabase() {
        projectList = new ArrayList<>();
    }

    public Project addProject(Project project) {
        if (isValidProject(project)) {
            projectList.add(project);
            return project;
        }
        return null;
    }

    public List<Project> getAllProjects() {
        return projectList;
    }

    public void deleteProject(UUID projectId) {
        projectList.stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst().ifPresent(projectList::remove);
    }

    public Project findById(UUID projectId) {
        return projectList.stream()
                .filter(project -> project.getId().equals(projectId))
                .findFirst().orElseThrow();
    }

    private boolean isValidProject(Project project) {
        if (project.getTitle().equals(null) || project.getTitle().equals("")) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (!project.getGithubLink().startsWith("https://github.com/")) {
            throw new IllegalArgumentException("Link must start with -> https://github.com");
        }
        return true;
    }


}
