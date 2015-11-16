package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;

public class ProjectFileDAO extends FileDAO<Project> implements ProjectStorage {

    public ProjectFileDAO() {
        super(Project.class);
    }

    public ProjectFileDAO(String pathToFile) {
        super(Project.class, pathToFile);
    }

}
