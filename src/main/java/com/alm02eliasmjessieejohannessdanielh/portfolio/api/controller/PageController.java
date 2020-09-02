package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import com.alm02eliasmjessieejohannessdanielh.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    private final ProjectService projectService;

    @Autowired
    public PageController(ProjectService projectService){
        this.projectService = projectService;
    }


    @GetMapping("/")
    public String homePage(Model model) {
        List<Project> projectList = projectService.getAllProjects();
        model.addAttribute("projectList", projectList);
        return "index";
    }

    @GetMapping("/createproject")
    public String projectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "add-project";
    }
}
