package nikfisher.kickstarter.dao;

import nikfisher.kickstarter.model.Category;

import java.util.List;

public interface Categories {

    void add(Category category);

    List<String>  getCategories();

    Category get(int id);

    int size();

}
