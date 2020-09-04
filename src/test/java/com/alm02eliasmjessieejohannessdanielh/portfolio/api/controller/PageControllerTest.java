package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.database.MockDatabase;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.validation.BindingResult;


import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class PageControllerTest {

    @Autowired
    MockMvc mockMvc;
    MockDatabase mockDatabase;
    ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mockDatabase = mock(MockDatabase.class);
        mapper = new ObjectMapper();
    }

    @Test
    void loadAllProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/")
        ).andExpect(status().isOk());
    }

    @Test
    void viewProjectForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/add-project")
        ).andExpect(status().isOk());
    }

    @Test
    void addProject() throws Exception {
        Project project = new Project();
        project.setTitle("Title");
        project.setGithubLink("https://github.com/real-project");
        BindingResult bindingResult = mock(BindingResult.class);

        when(mockDatabase.addProject(any(Project.class))).thenReturn(new Project());

        mockMvc.perform(MockMvcRequestBuilders
                .post("/add-project")
                .flashAttr("project", project)
        ).andExpect(status().is3xxRedirection());
    }

    @Test
    void addProjectWouldFail() throws Exception {
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/add-project")
        ).andExpect(status().isOk());
    }

    @Test
    void deleteProject() throws Exception {
        UUID mockUUID = UUID.randomUUID();

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/delete-project/" + mockUUID.toString())
        ).andExpect(status().is3xxRedirection());
    }
}