package com.alm02eliasmjessieejohannessdanielh.portfolio.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.UUID;

import static javax.persistence.GenerationType.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @Size(min = 1, max = 255, message = "Description must be between 1-255 characters")
    private String description;

    @NotEmpty(message = "Must provide one contributor")
    private String contributors;

    // Fix regex for github link validaton
    private String githubLink;

    @NotEmpty
    private String codingLanguage;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getCodingLanguage() {
        return codingLanguage;
    }

    public void setCodingLanguage(String codingLanguage) {
        this.codingLanguage = codingLanguage;
    }
}
