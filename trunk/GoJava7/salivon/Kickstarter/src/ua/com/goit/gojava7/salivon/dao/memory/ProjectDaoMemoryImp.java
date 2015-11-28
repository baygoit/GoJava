package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.ProjectDao;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

public class ProjectDaoMemoryImp implements ProjectDao {

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        List<Project> projects = StoreProjects.getProjects();
        List<Project> requestedCategory = new ArrayList<>();
        for (Project project : projects) {
            if (project.getIdCategory() == idCategory) {
                requestedCategory.add(project);
            }
        }
        return requestedCategory;
    }

    @Override
    public Project getProject(int idProject) {
        List<Project> projects = StoreProjects.getProjects();
        Project requestedProject = null;
        for (Project project : projects) {
            if (project.getId() == idProject) {
                requestedProject = project;
                break;
            }
        }
        return requestedProject;
    }

}
