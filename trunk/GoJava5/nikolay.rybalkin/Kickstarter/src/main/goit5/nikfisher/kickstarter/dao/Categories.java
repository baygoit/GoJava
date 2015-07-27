package goit5.nikfisher.kickstarter.dao;

import goit5.nikfisher.kickstarter.model.Category;

import java.util.List;

public interface Categories {

    void add(Category category);

    List<String>  getCategories();

    Category get(int index);

    int size();
}
