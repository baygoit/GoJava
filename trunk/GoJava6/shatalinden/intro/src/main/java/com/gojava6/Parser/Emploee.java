package com.gojava6.Parser;

/**
 * Created by shata on 23.09.2015.
 */
public class Emploee implements  Comparable<Emploee>{

    public int id;
    public String name;
    public int managerID;

    public Emploee(int id, String name, int managerID) {
        this.id = id;
        this.name = name;
        this.managerID = managerID;
    }

    @Override
    public int compareTo(Emploee empl) {
        return managerID-empl.managerID;
    }
}
