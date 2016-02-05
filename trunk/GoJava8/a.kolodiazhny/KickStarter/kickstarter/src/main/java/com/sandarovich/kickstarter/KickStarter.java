package com.sandarovich.kickstarter;

import com.sandarovich.kickstarter.menu.AbstractMenu;
import com.sandarovich.kickstarter.menu.ConsoleMenuReader;
import com.sandarovich.kickstarter.menu.MainMenu;
import com.sandarovich.kickstarter.menu.MenuReader;

/**
 * @author Olexander Kolodiazhny 2016
 *  KickStrter annalog.
 *  
 */

public class KickStarter {
    
    public static final String APP_VERSION = "0.0.2";
 
    public static void main(String[] args) {
        new KickStarter().start();
    }
    
    public void start() {
        
        Output output = new ConsoleOutput();
        new Intro(output, APP_VERSION).show();
       
        MenuReader menuReader = new ConsoleMenuReader();
        AbstractMenu menu = new MainMenu(output, menuReader);
        menu.show();
        menu.doAction(menu.readUserFeedback());   
        Project p = new Project.Builder(1, Category.IT)
        		.description("USB Lighter")
        		.shortDescription("USB Lighter")
        		.goalAmount(10000)
        		.collectedAmount(200)
                .build();
    }

}
