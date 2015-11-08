package com.morkva.entities;

import com.morkva.model.dao.Identified;

/**
 * Created by vladyslav on 02.05.15.
 */
public class Category implements Identified<Integer> {

    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }



}
