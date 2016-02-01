package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016 Describes common stuff for all menu
 */

public abstract class AbstractMenu {

    protected MenuElement[] menuElements;
    protected String headerLabel;
    protected int menuId;
    protected Output output;
    protected MenuReader menuReader;
 
    public void show() {
        output.print("-----------");
        output.print("{" + menuId + "}" + headerLabel);
        output.print("-----------");
        for (int index = 0; index < menuElements.length; index++) {
            output.print(menuElements[index].toString());
        }
        output.print("---");
    }

    public int readUserFeedback() {
        int result = menuReader.read();
        return validateMenuElement(result);
    }

    private int validateMenuElement(int checkedNumber) {
        int result = checkedNumber;
        while (result < 0 || result > menuElements.length - 1) {
            output.print(">> Option is not found. Please try again");
            result = menuReader.read();
        }
        return result;
    }

    public abstract void doAction(int choise);

}
