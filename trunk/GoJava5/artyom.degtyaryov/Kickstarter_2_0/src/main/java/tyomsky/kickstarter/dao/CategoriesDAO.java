package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Category;

public interface CategoriesDAO {

    int size();

    Category get(int index);

    void add(Category category);

}
