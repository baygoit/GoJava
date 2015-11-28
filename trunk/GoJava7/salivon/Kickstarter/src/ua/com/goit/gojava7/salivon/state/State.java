package ua.com.goit.gojava7.salivon.state;

import java.util.Scanner;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public abstract class State {

    protected static Scanner scan = new Scanner(System.in);
    protected String menu;
    private static int idCategory;
    private static int idProject;
    private boolean commandExit = true;
    private boolean commandZero = true;
    private static String inData;
    private static DataType currentDataType;

    public abstract void outputContentState();

    public abstract void changeState(Console context);

    public abstract boolean validate(String data);

    public static DataType getCurrentDataType() {
        return currentDataType;
    }

    public static void setCurrentDataType(DataType command) {
        State.currentDataType = command;
    }

    protected String getInData() {
        return inData;
    }

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

    public static int getIdCategory() {
        return idCategory;
    }

    public static void setIdCategory(int indexCategory) {
        State.idCategory = indexCategory;
    }

    public static int getIdProject() {
        return idProject;
    }

    public static void setIdProject(int indexProject) {
        State.idProject = indexProject;
    }

    public void verification() {

        while (true) {
            inData = readUserInformations().trim();
            if (inData.equalsIgnoreCase("q") && commandExit) {
                return;
            }
            if (inData.equals("0") && commandZero) {
                return;
            }
            if (!validate(inData)) {
                System.out.println("Enter the correct data!");
                System.out.println(menu);
                continue;
            }
            return;
        }
    }

    public String readUserInformations() {
        String inData = State.scan.nextLine();
        return inData;
    }

    protected void performExit() {
        System.out.println("Goodbye my LORD!");
        State.getScan().close();
        Runtime.getRuntime().exit(0);
    }

    public void nextState(Console context) {
        context.execute();
    }

}
