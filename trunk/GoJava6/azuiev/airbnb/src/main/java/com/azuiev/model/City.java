package com.azuiev.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */

@Entity
@Table(name="city", catalog = "airbnb")
public class City {
    private Long id;
    private String name;

    private List<Image> image = new ArrayList<Image>();

    public City() {
    }

    //getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "city")
    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image=image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //other
    public String imagePath(){
        return "images/city/"+image.get(0).getName();
    }
}
