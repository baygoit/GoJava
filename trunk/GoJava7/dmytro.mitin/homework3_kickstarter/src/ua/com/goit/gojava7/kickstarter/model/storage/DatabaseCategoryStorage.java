package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;

import java.util.Arrays;
import java.util.List;

public class DatabaseCategoryStorage implements CategoryStorage {
    @Override
    public List<Category> getCategories() {
        return Arrays.asList(new Category(""));
    }

    @Override
    public void add(Category category) {

    }
}
