package com.azuiev.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */

@Entity
@Table(name="city")
public class City {
    private Long id;
    private String name;
    private List<Image> image;

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

    @OneToMany
    @JoinColumn(name="city")
    public List<Image> getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image.add(image);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String imagePath(){
        return "city/images/";
                /*+image;*/
    }
}
