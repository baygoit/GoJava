package com.gojava.view;

public class Level4 implements Level{
    private int position = 4;

    public Level4() {
        
    }
    @Override
    public String displayMySelf(int categoryNumber) {
        String nameMessage = "Please, enter your name";
        return nameMessage;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
