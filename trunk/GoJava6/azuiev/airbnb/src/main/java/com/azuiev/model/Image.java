package com.azuiev.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 09.11.15.
 */
@Entity
@Table(name="CityImages")
public class Image {
    private Long id;
    private City city;
    private String name;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")

    @Column(name="id")
    public Long getId() {
        return id;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    public City getCity() {
        return city;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

     public void setId(Long id) {
        this.id = id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }
}
