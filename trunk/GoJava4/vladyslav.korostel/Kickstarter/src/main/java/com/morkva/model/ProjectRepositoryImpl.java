package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Project;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by koros on 15.06.2015.
 */
public class ProjectRepositoryImpl implements ProjectRepository {

    DAO<Project, Integer> projectDao;

    public ProjectRepositoryImpl(DAO<Project, Integer> projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getProjectsForCategory(Category category) {
        List<Project> result = new LinkedList<>();
        try {
            List<Project> all = projectDao.getAll();
            for (Project project : all) {
                if (Objects.equals(project.getCategory().getId(), category.getId())) {
                    result.add(project);
                }
            }
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Project getById(Integer keyCode) {
        Project project = null;
        try {
            project = projectDao.getByPK(keyCode);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        try {
            projectDao.update(project);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
