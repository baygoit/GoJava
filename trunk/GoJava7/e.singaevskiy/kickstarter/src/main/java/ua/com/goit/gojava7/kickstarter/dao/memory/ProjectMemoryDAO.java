package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectMemoryDAO extends MemoryDAO<Project> implements ProjectDAO{

    public ProjectMemoryDAO(List<Project> dataSource) {
        super(dataSource);
    }

    @Override
    public List<Project> getByCategory(int categoryId) {
        return this.getAll().stream()
                .filter(project -> project.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

}
