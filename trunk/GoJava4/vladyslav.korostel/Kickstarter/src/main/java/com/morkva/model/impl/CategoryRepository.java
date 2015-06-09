package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.entities.Quote;
import com.morkva.model.IRepository;

import java.util.*;

/**
 * Created by vladyslav on 17.05.15.
 */
public class CategoryRepository implements IRepository<Category> {

    List<Category> categories;

    public CategoryRepository(List<Category> dataSource) {
        this.categories = dataSource;
    }

    public CategoryRepository() {
        this.categories = new ArrayList<>();
    }

    @Override
    public Category getById(int id) {
        if (categories.size() == 0) {
            return null;
        } else {
            int searchResult = search(id);
            return categories.get(searchResult);
        }
    }

    @Override
    public Category add(Category object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            categories.add(object);
            sort();
        }
        return null;
    }

    @Override
    public void remove(Category object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            categories.remove(object);
        }
    }

    @Override
    public void update(Category object) {
        int index = search(object.getId());
        if (index > 0) {
            categories.set(index, object);
            sort();
        }
    }

    @Override
    public List<Category> getAll() {
        if (categories.size() == 0) {
            return null;
        } else {
            return categories;
        }
    }

    private int search(int id) {
        return Collections.binarySearch(categories, id);
    }

    private void sort() {
        Collections.sort(categories, (o1, o2) -> o1.compareTo(o2.getId()));
    }
}
