package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.ui.Input;

public abstract class Menu<T> {

    protected Menu childMenu;
    protected Input input;

    public Menu(Input input) {
        this.input = input;
    }

    public void run() {
        while (true) {
            ask();
            int chosenMenuIndex = Integer.parseInt(input.read());
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
