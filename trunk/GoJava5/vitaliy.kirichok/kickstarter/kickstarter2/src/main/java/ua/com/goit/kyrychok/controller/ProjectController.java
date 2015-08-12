package ua.com.goit.kyrychok.controller;

import ua.com.goit.kyrychok.dao.ProjectDao;
import ua.com.goit.kyrychok.domain.Project;
import ua.com.goit.kyrychok.model.Converter;
import ua.com.goit.kyrychok.model.ProjectModel;

public class ProjectController {
    private ProjectDao projectDao;

    public ProjectController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public ProjectModel getModel(int id) {
        Project project = projectDao.load(id);
        return Converter.convert(project);
    }
}
