package ua.com.goit.gojava7.salivon.state;

import java.util.Scanner;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandler;
import ua.com.goit.gojava7.salivon.context.Console;

public abstract class State {

    protected static Scanner scan = new Scanner(System.in);
    protected String menu;
    protected ErrorHandler handler;
    private static int indexCategory;
    private static int indexProject;
    private boolean commandExit = true;
    private boolean commandZero = true;

    public abstract void outputContentState();

    protected abstract void changeState(Console context, String inData);

    public boolean isCommandZero() {
        return commandZero;
    }

    public void setCommandZero(boolean commandZero) {
        this.commandZero = commandZero;
    }

    public boolean isCommandExit() {
        return commandExit;
    }

    public void setCommandExit(boolean commandExit) {
        this.commandExit = commandExit;
    }

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

        while (true) {
            String inData = readUserInformations();
            if (inData.equalsIgnoreCase("q") && commandExit) {
                performExit();
            }
            if (inData.equals("0") && commandZero) {
                changeState(context, inData);
                return;
            }
            if (!handler.validate(inData)) {
                System.out.println("Enter the correct data!");
                System.out.println(menu);
                continue;
            } else {
                changeState(context, inData);
                return;
            }
        }
    }

    public String readUserInformations() {
        String inData = State.scan.next();
        return inData;
    }

    protected void performExit() {
        System.out.println("Goodbye my LORD!");
        State.getScan().close();
        Runtime.getRuntime().exit(0);
    }

}
