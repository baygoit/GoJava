package com.gojava6.enumchange;

/**
 * Created by sergiigetman on 10/5/15.
 */
public enum Color implements EnumHelper{
    RED("red"), GREEN("green"), YELLOW("yellow");

    String color;

    Color(String color) {
        this.color = color;
    }

    public String getName() {
        return color;
    }

    public EnumHelper getByName(String name) {
        return Color.valueOf(name);
    }
}
