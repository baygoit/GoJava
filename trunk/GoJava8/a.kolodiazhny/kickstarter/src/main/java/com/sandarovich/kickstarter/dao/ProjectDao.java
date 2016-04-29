package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Category;
import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> findByCategory(Category category);
    Project findById(long projectId);
}
