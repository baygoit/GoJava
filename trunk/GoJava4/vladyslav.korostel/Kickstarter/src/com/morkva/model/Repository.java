package com.morkva.model;

import com.morkva.entities.utils.ID;

/**
 * Created by vladyslav on 07.05.15.
 */
public interface Repository<T> {

    T getByIndex(int index);
    T getById(ID id);
    boolean add(T object);
    boolean remove(T object);
    boolean update(T object);
    int size();
}
