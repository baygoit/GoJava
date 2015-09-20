package com.gojava2.kickstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.ProjectStatus;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Integer> {
}