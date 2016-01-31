package com.sandarovich.kickstarter.menu;


/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public enum Actions {
    
    EXIT(0),
    SHOW_ALL_CATEGORIES(1),
    SHOW_CATEGORY(2);
    
    private int id;
    
    private Actions(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

   

}
