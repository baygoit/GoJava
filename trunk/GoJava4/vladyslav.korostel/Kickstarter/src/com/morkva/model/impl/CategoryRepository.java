package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.model.Repository;

import java.util.Arrays;

/**
 * Created by vladyslav on 17.05.15.
 */
public class CategoryRepository implements Repository<Category> {

    Category[] categories;

    public CategoryRepository(Category[] categories) {
        this.categories = categories;
    }

    public CategoryRepository() {
        this.categories = new Category[0];
    }

    @Override
    public Category getById(int id) {
        if (categories.length == 0) {
            return null;
        } else {
            int searchResult = search(id);
            return categories[searchResult];
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
        if (categories.length == 0) {
            return null;
        } else {
            return categories[index];
        }
    }

    @Override
    public boolean add(Category object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            Category[] temp = Arrays.copyOf(categories, categories.length + 1);
            temp[temp.length - 1] = object;
            this.categories = temp;
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
            System.arraycopy(categories, searchResult + 1, categories, searchResult, categories.length - 1 - searchResult);
            categories = Arrays.copyOf(categories, categories.length - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Category object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            categories[searchResult] = object;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return categories.length;
    }

    @Override
    public Category[] getAll() {
        if (categories.length == 0) {
            return null;
        } else {
            return categories;
        }
    }

    private int search(int id) {
        return Arrays.binarySearch(categories, id);
    }

    private void sort() {
        Arrays.sort(categories, (o1, o2) -> o1.compareTo(o2.getId()));
    }
}
