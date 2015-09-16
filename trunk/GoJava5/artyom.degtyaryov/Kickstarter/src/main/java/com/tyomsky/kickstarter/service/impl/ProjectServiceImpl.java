package com.tyomsky.kickstarter.service.impl;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public ProjectServiceImpl(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public List<Project> getProjectsByCategory(Category category) {
        return projectDAO.getListByCategory(category);
    }

    @Override
    public Project getProjectById(int id) {
        return projectDAO.get(id);
    }

}
