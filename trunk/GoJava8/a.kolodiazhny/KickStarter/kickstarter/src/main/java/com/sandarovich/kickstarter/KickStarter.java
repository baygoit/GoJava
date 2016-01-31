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
    
    public static final String APP_VERSION = "0.0.1";
 
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
        
    }

}
