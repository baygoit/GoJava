package ua.com.scread.kickstarter.controller;

import ua.com.scread.kickstarter.io.IO;

public abstract class Menu {
    private IO io;
    
    public Menu(IO io) {
        this.io = io;
    }
    
    public void run() {
        while (true) {
            ask(); 
            
            int menuItem = io.read();
            if (menuItem == 0)
                break;
            
            Object selected = choose(menuItem);
            if (selected == null)
                continue;
            
            Menu subMenu = nextMenu(selected);
            if ( subMenu != null) {
                subMenu.run();                
            } else {
                break;
            }
        }
    }

    abstract Menu nextMenu(Object selected);

    abstract Object choose(int menuItem);

    abstract void ask();
}
