package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Entity;

import java.util.List;

/**
 * Created by vladyslav on 07.05.15.
 */
public interface IRepository<T extends Entity> {

    T getById(int id);
    T findByName(String name);
    T getByIndex(int index);
    boolean add(T object);
    boolean remove(T object);
    boolean update(T object);
    int size();
    List<T> getAll();
}
