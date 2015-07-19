package goit5.nikfisher.kickstarter.model;

import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

public abstract class Menu {

    private InputOutputConsoleInterface io;

    public Menu(InputOutputConsoleInterface io){
        this.io = io;
    }

    public void runMenu() {

        while (true){

            ask();

            int menuIndex = io.consoleScan();

            if (menuIndex == 0){
                break;
            }

            Object selected = choose(menuIndex);

            if (selected == null){
                continue;
            }

            Menu subMenu = nextMenu(selected);
            if (subMenu != null){
                subMenu.runMenu();
            }
        }
    }

    public abstract Menu nextMenu(Object selected);

    public abstract Object choose(int menuIndex);

    public abstract void ask();
}
