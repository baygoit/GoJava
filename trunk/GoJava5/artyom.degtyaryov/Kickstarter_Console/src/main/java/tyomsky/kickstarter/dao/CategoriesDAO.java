package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Category;

import java.util.List;

public interface CategoriesDAO {

    int size();

    Category get(int index);

    List<Category> getAll();

    void add(Category category);

}
