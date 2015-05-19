package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.model.Repository;

import java.util.*;

/**
 * Created by vladyslav on 17.05.15.
 */
public class CategoryRepository implements Repository<Category> {

    List<Category> categories;

    public CategoryRepository(List<Category> categories) {
        this.categories = categories;
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
    public Category findByName(String name) {
        Category result = null;
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                result = category;
            }
        }
        return result;
    }

    @Override
    public Category getByIndex(int index) {
        if (categories.size() == 0) {
            return null;
        } else {
            return categories.get(index);
        }
    }

    @Override
    public boolean add(Category object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            categories.add(object);
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Category object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            categories.remove(object);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Category object) {
        int index = search(object.getId());
        if (index > 0) {
            categories.set(index, object);
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return categories.size();
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
