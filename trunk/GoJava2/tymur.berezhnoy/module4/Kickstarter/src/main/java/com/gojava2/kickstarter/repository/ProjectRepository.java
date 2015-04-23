package com.gojava2.kickstarter.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gojava2.kickstarter.entity.Category;
import com.gojava2.kickstarter.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	List<Project> findByCategory(Category category, Pageable pageable);
}