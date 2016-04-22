package com.sandarovich.kickstarter.dao;


import com.sandarovich.kickstarter.model.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getByCategoryId(long categoryId);
    Project findById(int projectId);

    Long getCategoryId(long projectId);

}
