package com.alm02eliasmjessieejohannessdanielh.portfolio.api.controller;

import com.alm02eliasmjessieejohannessdanielh.portfolio.database.MockDatabase;
import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PageController implements WebMvcConfigurer {

    MockDatabase database = new MockDatabase();


    @GetMapping("/")
    public String loadAllProjects(Model model) {
        List<Project> projectList = database.getAllProjects();
        model.addAttribute("projectList", projectList);
        return "index";
    }

    @GetMapping("/add-project")
    public String projectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "add-project";
    }

    @PostMapping("/add-project")
    public String addProject(@Valid Project project, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "add-project";
        }

        database.addProject(project);
        return "redirect:/";

    }



}
