package org.kudryavtsev.kickstarter.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Model {
    private List<Category> categories;

    public Model() {
        categories = new ArrayList<Category>();
    }

    public void setCategoriesList(List<Category> categories) {
        this.categories = categories;
    }
    
    public List<Category> getCategoriesList() {
        return categories;
    }

    public List<Project> getCategoryProjects(int index) {
        return categories.get(index).getProjects();
    }
    
    public int categoriesCount() {
        return categories.size();
    }
    
    public Iterator<Category> getCategories() {
        return categories.iterator();
    }

    public void add(Category category) {
        categories.add(category);
    }

    public void addProjectToCategory(int category, Project project) {
        categories.get(category).getProjects().add(project);
    }

}
