package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016
 *
 */

public class MainMenu extends AbstractMenu{

    public MainMenu(Output output, MenuReader menuReader) {
    	super(output,menuReader);
        menuId = 0;
        headerLabel = "Main Menu:";
        menuElements = new MenuElement[2];
        menuElements[0] = new MenuElement("Show categories", Actions.SHOW_ALL_CATEGORIES, 0);
        menuElements[1] = new MenuElement("Exit", Actions.EXIT, 1);
        
    }
 
    @Override
    public void doAction(int choise) {
        Actions action = menuElements[choise].getAction();
        
        if (action == Actions.EXIT) {
            output.print(">> Bye");
            System.exit(0);
        } 
        
        if (action == Actions.SHOW_ALL_CATEGORIES) {
            AbstractMenu menu = new CategoryMenu(output, menuReader);
            menu.show();
            menu.doAction(menu.readUserFeedback());
        }
        
    }
    
}
