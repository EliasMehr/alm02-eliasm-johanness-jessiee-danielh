package com.alm02eliasmjessieejohannessdanielh.portfolio;

import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;

public class ProjectMockData {

    public static Project generateProject(){
        Project project = new Project();
        project.setTitle("Great Title");
        project.setContributors("Many people");
        project.setDescription("Bla bla");
        project.setCodingLanguage("Java ofc");
        project.setGithubLink("https://github.com/best-project");
        return project;
    }
}
