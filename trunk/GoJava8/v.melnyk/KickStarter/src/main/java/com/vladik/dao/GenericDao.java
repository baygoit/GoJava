package com.vladik.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {
    void add(T element);

    void remove(T element);

    List<T> getAll();

    int getSize();
}
