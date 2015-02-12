package com.gojava.view;

public class Level4 implements Level {
    Menu menu;
    private int position = 4;


    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String displayMySelf(int categoryNumber) {
        menu.clientInteraction.interactions.get(categoryNumber - 1).displayInteractinSet();
        return "";
    }

    @Override
    public int getPosition() {
        return position;
    }
}
