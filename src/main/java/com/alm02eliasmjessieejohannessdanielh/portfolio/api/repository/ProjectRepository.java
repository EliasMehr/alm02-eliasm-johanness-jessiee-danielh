package com.alm02eliasmjessieejohannessdanielh.portfolio.api.repository;

import com.alm02eliasmjessieejohannessdanielh.portfolio.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
