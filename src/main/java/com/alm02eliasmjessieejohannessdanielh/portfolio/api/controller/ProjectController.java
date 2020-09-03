package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.database.MockDatabase;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v2/")
public class ProjectController {

    private MockDatabase database = new MockDatabase();

    @GetMapping("projects")
    public List<Project> getAllProjects() {
        return database.getAllProjects();
    }

    @PostMapping("projects")
    public ResponseEntity<Object> addProject(@RequestBody Project project) {
        try {
            database.addProject(project);
            return ResponseEntity.ok(project);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("projects/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable UUID id) {
        try {
            database.deleteProject(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
