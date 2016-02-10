package com.sandarovich.kickstarter.menu;

/**
 * @author Olexander Kolodiazhny 2016
 *      Describe Every Menu element
 */

public class MenuElement {
    
    private String nameLabel;
    private Actions action;
    private int id;
       
    public MenuElement(String nameLabel, Actions action, int id) {
        this.nameLabel = nameLabel;
        this.action = action;
        this.id = id;
    }
    
    public Actions getAction() {
        return this.action;
    }
    
    public String getNameLabel() {
    	return this.nameLabel;
    }

    @Override
    public String toString() {
        String result =  this.id + " - " + nameLabel;
        return result;
    }
    
    
}
