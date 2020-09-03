package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.database.MockDatabase;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProjectControllerTest {

    @Autowired
    MockMvc mockMvc;
    MockDatabase mockDatabase;
    ObjectMapper jsonMapper;

    @BeforeEach
    void setUp() {
        mockDatabase = mock(MockDatabase.class);
        jsonMapper = new ObjectMapper();
    }

    @DisplayName("should return a list of projects from")
    @Test
    public void getAllProjects() throws Exception {
        // when
        List<Project> projectsInDb = List.of(new Project(), new Project());

        when(mockDatabase.getAllProjects()).thenReturn(projectsInDb);

        // then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v2/projects")

        )
                .andExpect(status().isOk())
                .andExpect(result ->
                        result.getResponse().getContentAsString().equals(projectsInDb.toString()));
    }


    @Test
    public void addProject() {
        
    }

    @Test
    void deleteProject() {
    }
}