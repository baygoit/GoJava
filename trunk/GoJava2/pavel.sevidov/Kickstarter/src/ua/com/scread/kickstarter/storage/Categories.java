package ua.com.scread.kickstarter.storage;

import java.util.List;

import ua.com.scread.kickstarter.data.Category;

public interface Categories {

    void add(Category category);

    int size();

    List<Category> getCategories();

    Category get(int index);
}