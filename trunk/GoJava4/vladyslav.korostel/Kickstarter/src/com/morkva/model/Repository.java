package com.morkva.model;

/**
 * Created by vladyslav on 07.05.15.
 */
public interface Repository<T> {

    T getByIndex(int index);
    T getById(int id);
    boolean add(T object);
    boolean remove(T object);
    boolean update(T object);
    int size();
}
