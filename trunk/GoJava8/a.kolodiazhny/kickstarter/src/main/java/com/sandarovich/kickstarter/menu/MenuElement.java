package com.sandarovich.kickstarter.menu;

/**
 * @author Olexander Kolodiazhny 2016
 *      Describe Every Menu element
 */

public class MenuElement {

    private final String nameLabel;
    private final Actions action;
    private final int id;
       
    public MenuElement(String nameLabel, Actions action, int id) {
        this.nameLabel = nameLabel;
        this.action = action;
        this.id = id;
    }
    
    public Actions getAction() {
        return this.action;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.id + " - " + nameLabel;
    }
    
    
}
