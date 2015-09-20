package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getProjectsByCategory(Category category);

    Project getProjectById(int id);

}
