/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.state;

import java.util.Scanner;
import ua.com.goit.gojava7.salivon.handlers.HandlerError;
import ua.com.goit.gojava7.salivon.view.Console;

/**
 *
 * @author Salivon Ivan
 */
public abstract class State {

    protected static Scanner scan = new Scanner(System.in);
    protected String menu;
    protected HandlerError handler;
    private static int indexCategory;
    private static int indexProject;
   
    public static Scanner getScan() {
        return scan;
    }

    public static int getIndexCategory() {
        return indexCategory;
    }

    public static void setIndexCategory(int indexCategory) {
        State.indexCategory = indexCategory;
    }

    public static int getIndexProject() {
        return indexProject;
    }

    public static void setIndexProject(int indexProject) {
        State.indexProject = indexProject;
    }

    public void verification(Console context) {
        String inData = readUserInformations();
        if (!handler.validate(inData)) {
            System.out.println("Enter the correct data!");
            verification(context);

        } else {
            changeState(context, inData);
        }
    }

    public String readUserInformations() {
        String inData = State.scan.next();
        return inData;
    }

    public abstract void outputContentState();

    protected abstract void changeState(Console context, String inData);

}
