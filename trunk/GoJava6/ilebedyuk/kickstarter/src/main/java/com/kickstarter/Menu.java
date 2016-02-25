package com.kickstarter;

/**
 * Created by Игорь on 25.02.2016.
 */
public abstract class Menu {
    private IO io;

    public Menu(IO io) {
        this.io = io;
    }

    public void run() {
        while (true) {
            ask();
            int menu = io.read();
            if (menu == 0) {
                break;
            }

            Object selected = choose(menu);
            if (selected == null) {
                continue;
            }
            Menu subMenu = nextMenu(selected);
            if (subMenu != null) {
                subMenu.run();
            }
        }
    }

    abstract Menu nextMenu(Object selected);

    abstract Object choose(int menu);

    abstract void ask();
}
