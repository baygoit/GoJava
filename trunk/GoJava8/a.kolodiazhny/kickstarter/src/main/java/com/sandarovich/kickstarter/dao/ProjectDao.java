package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getByCategory(int categoryId);

    Project findById(int projectId);

}
