package com.azuiev.model;

/**
 * Created by Masta on 31.10.2015.
 */
public class City {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;

    }
}
