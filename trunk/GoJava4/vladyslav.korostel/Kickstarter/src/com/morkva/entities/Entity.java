package com.morkva.entities;

import com.morkva.entities.utils.ID;

/**
 * Created by vladyslav on 07.05.15.
 */
public abstract class Entity implements Comparable<ID> {

    private ID id;

    public Entity(Integer id) {
        this.id = new ID(id);
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public int compareTo(ID o) {
        return this.id.compareTo(o);
    }
}
