package com.morkva.model;

import com.morkva.entities.Entity;

/**
 * Created by vladyslav on 07.05.15.
 */
public interface Repository<T extends Entity> {

    T getById(int id);
    T findByName(String name);
    T getByIndex(int index);
    boolean add(T object);
    boolean remove(T object);
    boolean update(T object);
    int size();
    T[] getAll();
}
