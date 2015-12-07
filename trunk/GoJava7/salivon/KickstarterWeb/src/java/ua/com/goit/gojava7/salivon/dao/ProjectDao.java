package ua.com.goit.gojava7.salivon.dao;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;

public interface ProjectDao {

    public List<Project> getProjectsOfCategory(int idCategory);

    public Project getProject(int idProject);
}
