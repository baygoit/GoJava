package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Category;

import java.io.File;
import java.util.List;

public class FileCategoryStorage implements CategoryStorage {
    @Override
    public List<Category> getCategories() {
        File file = new File("D:\\workspace\\goit-kickstarter\\resources\\quotes.txt");
        return null;
    }

    @Override
    public void add(Category category) {

    }
}
