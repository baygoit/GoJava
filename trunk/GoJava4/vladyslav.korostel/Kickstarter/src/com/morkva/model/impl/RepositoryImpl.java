package com.morkva.model.impl;

import com.morkva.entities.Entity;
import com.morkva.model.Repository;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by vladyslav on 11.05.15.
 */
public class RepositoryImpl<T extends Entity> implements Repository<T> {

    private T[] objects;

    public RepositoryImpl(T[] objects) {
        this.objects = objects;
        sort();
    }

    @Override
    public T getByIndex(int index) {
        return objects[index];
    }

    @Override
    public T getById(int id) {
        int searchResult = search(id);
        return objects[searchResult];
    }

    @Override
    public boolean add(T object) {
        int searchResult = search(object.getId());
        if (searchResult < 0) {
            T[] temp = Arrays.copyOf(objects, objects.length + 1);
            temp[temp.length - 1] = object;
            this.objects = temp;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean remove(T object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            System.arraycopy(objects, searchResult + 1, objects, searchResult, objects.length - 1 - searchResult);
            objects = Arrays.copyOf(objects, objects.length - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(T object) {
        int searchResult = search(object.getId());
        if (searchResult > 0) {
            objects[searchResult] = object;
            sort();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return objects.length;
    }

    private int search(int id) {
        return Arrays.binarySearch(objects, id);
    }

    private void sort() {
        Arrays.sort(objects, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2.getId());
            }
        });
    }
}
