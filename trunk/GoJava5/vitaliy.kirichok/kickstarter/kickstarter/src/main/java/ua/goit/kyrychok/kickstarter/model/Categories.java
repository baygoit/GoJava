package ua.goit.kyrychok.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private List<Category> categories = new ArrayList<>();

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
