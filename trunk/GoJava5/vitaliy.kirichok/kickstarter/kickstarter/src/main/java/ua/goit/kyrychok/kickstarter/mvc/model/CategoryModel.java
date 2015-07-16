package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Project;

import java.util.List;

public class CategoryModel extends BaseModel {
    private Category category;

    public String getName() {
        return category.getName();
    }

    public List<Project> getProjects() {
        return category.getProjects();
    }

    public void update() {
        category = getDataProvider().getCategory(getIdentifier());
    }

    public int getCount() {
        return category.getProjects().size();
    }
}
