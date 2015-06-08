package com.morkva.entities;

/**
 * Created by vladyslav on 07.05.15.
 */
public abstract class Entity implements Comparable<Integer> {

    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Integer o) {
        return (id >o)?1:(id <o)?-1:0;
    }
}
