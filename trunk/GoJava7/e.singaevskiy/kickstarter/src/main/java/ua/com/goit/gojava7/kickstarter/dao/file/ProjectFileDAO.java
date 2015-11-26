package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.util.FileDAO;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectFileDAO extends FileDAO<Project> implements ProjectDAO {

    public ProjectFileDAO() {
        super(Project.class);
    }

    public ProjectFileDAO(String pathToFile) {
        super(Project.class, pathToFile);
    }

    @Override
    public Project get(int index) {
        for (Project element : getAll()) {
            if (element.getId() == index) {
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Project> getByCategory(int categoryId) {
        return this.getAll().stream()
                .filter(project -> project.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

}
