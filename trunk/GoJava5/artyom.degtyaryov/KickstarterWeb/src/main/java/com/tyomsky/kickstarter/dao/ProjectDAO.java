package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.model.Project;

import java.util.List;

public interface ProjectDAO {

    List<Project> getByCategoryId(int categoryId);

    Project getById(int id);

    void update(Project project);

}
