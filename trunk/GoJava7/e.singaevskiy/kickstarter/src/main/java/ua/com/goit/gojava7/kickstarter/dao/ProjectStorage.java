package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.beans.Project;

public interface ProjectStorage extends DataStorage<Project> {

    default List<Project> getByCategory(int categoryId){
        return this.getAll().stream()
                .filter(project -> project.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }
    
}
