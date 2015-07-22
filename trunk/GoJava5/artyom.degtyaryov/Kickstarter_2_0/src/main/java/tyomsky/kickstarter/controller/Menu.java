package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.ui.IO;

public abstract class Menu {

    private IO io;

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
            Object selected = select(chosenMenuIndex);
            if (selected == null) {
                continue;
            }
            Menu subMenu = nextMenu(selected);
            if (!(subMenu == null)) {
                subMenu.run();
            }
        }
    }

    public abstract Menu nextMenu(Object selected);

    public abstract Object select(int chosenMenuIndex);

    public abstract void ask();

}
