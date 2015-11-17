package model;

import java.io.Serializable;

/**
 * Created by root on 04.11.15.
 */
public abstract class Entity implements Serializable, Cloneable {

    private Integer id;

    public Entity() {}
    public Entity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}