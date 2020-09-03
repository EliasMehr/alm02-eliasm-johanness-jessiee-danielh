package com.alm02eliasmjessieejohannessdanielh.portfolio.database;

import com.alm02eliasmjessieejohannessdanielh.portfolio.ProjectMockData;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MockDatabaseTest {

    MockDatabase database;

    @BeforeEach
    void setUp() {
        database = new MockDatabase();
    }

    @AfterEach
    void tearDown() {
        database.getAllProjects().clear();
    }

    @Test
    @DisplayName("should add project to database")
    void should_add_Project_To_Database() {
        Project project = ProjectMockData.generateProject();

        database.addProject(project);
        Project projectInDb = database.findById(project.getId());
        assertThat(projectInDb.getTitle()).isEqualTo(project.getTitle());
        assertThat(projectInDb.getDescription()).isEqualTo(project.getDescription());
        assertThat(projectInDb.getId()).isEqualTo(project.getId());
        assertThat(projectInDb.getId()).isNotNull();
    }

    @Test
    @DisplayName("should fail to add project to database")
    void should_fail_to_add_project_to_database() {
        Project project = ProjectMockData.generateProject();
        project.setTitle("");
        assertThrows(IllegalArgumentException.class, () -> database.addProject(project), "Title cannot be empty or null");
        project.setTitle(null);
        assertThrows(IllegalArgumentException.class, () -> database.addProject(project), "Title cannot be empty or null");

        project.setTitle("Title");
        project.setGithubLink("https://gihub.com/blabla");
        assertThrows(IllegalArgumentException.class, () -> database.addProject(project), "Link must start with -> https://github.com");
    }

    @DisplayName("should delete project in DB list")
    @Test
    void deleteProject() {
        Project projectToDelete = new Project();
        projectToDelete.setTitle("Title");
        projectToDelete.setGithubLink("https://github.com/real-project");

        database.addProject(projectToDelete);
        database.deleteProject(projectToDelete.getId());

        assertThrows(NoSuchElementException.class, () -> database.findById(projectToDelete.getId()));
    }

    @DisplayName("should find project in DB list")
    @Test
    void findById() {
        Project projectToFind = new Project();
        projectToFind.setTitle("Title");
        projectToFind.setGithubLink("https://github.com/real-project");

        database.addProject(projectToFind);

        assertThat(database.findById(projectToFind.getId())).isEqualTo(projectToFind);
    }
}