package tyomsky.kickstarter.dao;

import tyomsky.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoriesDAOMemory implements CategoriesDAO {

    List<Category> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Category get(int index) {
        return data.get(index);
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(data);
    }

    @Override
    public void add(Category category) {
        data.add(category);
    }

}
