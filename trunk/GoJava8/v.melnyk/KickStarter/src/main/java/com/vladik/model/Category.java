package com.vladik.model;

import java.io.Serializable;

public class Category implements Serializable {
    private int uniqueID;
    private String name;
//    public static String TABLE_NAME = "Categories";

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id : " + uniqueID + ", name : " + name;
    }
}
