package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;


public class MainPageModel extends BaseModel {
    private List<Category> categories;

    public String getWelcomeMessage() {
        return getDataProvider().getWelcomeMessage();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void update() {
        categories = getDataProvider().getCategories();
    }

    public int getCount() {
        return categories.size();
    }
}
