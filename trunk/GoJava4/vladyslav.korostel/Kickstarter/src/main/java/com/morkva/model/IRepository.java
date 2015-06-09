package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.entities.Entity;
import com.morkva.entities.Quote;

import java.util.List;

/**
 * Created by vladyslav on 07.05.15.
 */
public interface IRepository<T extends Entity> {

    T getById(int id);
    T add(T object);
    void remove(T object);
    void update(T object);
    List<T> getAll();
}
