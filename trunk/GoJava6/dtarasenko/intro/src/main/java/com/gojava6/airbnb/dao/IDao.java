package com.gojava6.airbnb.dao;


import java.util.List;

public interface IDao {

    void createObject(Object o);
    void deleteObject(Integer i);
    void updateObject(Integer i);
    Object getObject(Integer i);
    List<Object> getObjectList();
}
