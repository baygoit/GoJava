package com.morkva.model.impl;

import com.morkva.entities.Category;
import com.morkva.entities.utils.ID;
import com.morkva.model.Repository;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vladyslav on 02.05.15.
 */
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
    public Category getById(ID id) {
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
                ID id1 = o1.getId();
                ID id2 = o2.getId();
                return id1.compareTo(id2);
//                return (id1.getValue() > id2.getValue())?1:(id1.getValue() < id2.getValue())?-1:0;
            }
        });
    }

    private int search(ID id) {
        return Arrays.binarySearch(categories, id);
    }
}
