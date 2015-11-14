package com.donishchenko.airbnb.model;

import com.google.common.base.Joiner;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public City() {}

    public City(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof City)) return false;

        City other = (City) obj;
        return id.equals(other.id) &&
                name.equals(other.name);
    }

    @Override
    public String toString() {
        return Joiner.on("").join(
                "City{id='", id, "', name='", name, "'}");
    }
}
