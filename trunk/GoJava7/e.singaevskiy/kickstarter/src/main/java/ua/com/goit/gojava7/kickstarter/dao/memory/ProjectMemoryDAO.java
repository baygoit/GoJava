package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;

public class ProjectMemoryDAO extends MemoryDAO<Project> implements ProjectStorage{

    public ProjectMemoryDAO(List<Project> dataSource) {
        super(dataSource);
    }

}
