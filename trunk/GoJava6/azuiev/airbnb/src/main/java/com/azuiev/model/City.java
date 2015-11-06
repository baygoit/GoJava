package com.azuiev.model;

/**
 * Created by Masta on 31.10.2015.
 */
public class City {
    private Integer id;
    private String name;
    private String image;

    public String getImage() {
        return "images/city/"+image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;

    }
}
