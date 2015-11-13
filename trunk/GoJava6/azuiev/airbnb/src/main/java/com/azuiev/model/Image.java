package com.azuiev.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 09.11.15.
 */
@Entity
@Table(name="cityimages", catalog = "airbnb")
public class Image {
    private Long id;
    private City city;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "id")
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
