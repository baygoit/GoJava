package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.model.Repository;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vladyslav on 02.05.15.
 */
@Deprecated
public class CategoryRepository implements Repository<Category> {

    private Category[] categories;

    public CategoryRepository(Category[] categories) {
        this.categories = categories;
        sort();
    }

    @Override
    public Category getByIndex(int index) {
        return categories[index];
    }

    @Override
    public Category getById(int id) {
        int searchResult = search(id);
        return categories[searchResult];
    }

    @Override
    public boolean add(Category category) {
        int searchResult = search(category.getId());
        if (searchResult < 0) {
            Category[] temp = Arrays.copyOf(categories, categories.length + 1);
            temp[temp.length - 1] = category;
            this.categories = temp;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(Category category) {
        int searchResult = search(category.getId());
        if (searchResult > 0) {
            System.arraycopy(categories, searchResult + 1, categories, searchResult, categories.length - 1 - searchResult);
            categories = Arrays.copyOf(categories, categories.length - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        int searchResult = search(category.getId());
        if (searchResult > 0) {
            categories[searchResult] = category;
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

    private void sort() {
        Arrays.sort(categories, new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.compareTo(o2.getId());
            }
        });
    }

    private int search(int id) {
        return Arrays.binarySearch(categories, id);
    }
}
