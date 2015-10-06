package com.gojava6.enumchange;

/**
 * Created by sergiigetman on 10/5/15.
 */
public enum Fruits implements EnumHelper{
    APPLE("apple"), CHERRY("cherry"), ORANGE("orange");

    String fruit;

    Fruits(String fruit) {
        this.fruit = fruit;
    }

    public String getName() {
        return fruit;
    }

    public Fruits getByName(String name) {
        return this;
    }
}
