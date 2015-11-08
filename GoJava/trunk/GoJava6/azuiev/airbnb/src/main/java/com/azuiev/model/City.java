package com.azuiev.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Masta on 31.10.2015.
 */

@Entity
@Table(name="city")
public class City {
    private Long id;
    private String name;
    private String image;

    public City() {
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }


    @Column(name="name")
    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String imagePath(){
        return "city/images/"+image;
    }
}
