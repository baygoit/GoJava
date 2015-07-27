package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.ui.IO;

public abstract class Menu<T> {

    protected Menu childMenu;
    protected IO io;

    public Menu(IO io) {
        this.io = io;
    }

    public void run() {
        while (true) {
            ask();
            int chosenMenuIndex = Integer.parseInt(io.read());
            if (chosenMenuIndex == 0) {
                break;
            }
            T selected = select(chosenMenuIndex);
            if (selected == null) {
                continue;
            }
            Menu subMenu = nextMenu(selected);
            if (!(subMenu == null)) {
                subMenu.run();
            }
        }
    }

    public abstract Menu nextMenu(T selected);

    public abstract T select(int chosenMenuIndex);

    public abstract void ask();

    public void setChildMenu(Menu childMenu) {
        this.childMenu = childMenu;
    }

}
