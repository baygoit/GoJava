package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Project;

import java.util.List;

/**
 * Created by koros on 15.06.2015.
 */
public interface ProjectRepository {

    List<Project> getProjectsForCategory(Category category);

    Project getById(Integer keyCode);
}
