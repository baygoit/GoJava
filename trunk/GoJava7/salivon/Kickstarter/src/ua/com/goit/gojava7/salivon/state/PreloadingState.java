package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DataType;

public class PreloadingState extends State {

    public PreloadingState() {
        menu = "Select data source:\n"
                + "- enter 1 - data from the file system\n"
                + "- enter 2 - data of the object model\n"
                + "- enter 3 - data of the DB model\n";
        setCommandZero(false);
        setCommandExit(false);
    }

    @Override
    public void outputContentState() {
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public boolean validate(String data) {
        try {
            int n = Integer.parseInt(data);

            return n == 1 || n == 2 || n == 3;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void changeState(Console context) {
        int inDateToInt = Integer.parseInt(getInData());
        selectCurrentData(inDateToInt);
        context.setCurrentState(new WelcomeState());
    }

    protected void selectCurrentData(int inData) {
        switch (inData) {

            case 1:
                setCurrentDataType(DataType.FILE);
                break;
            case 2:
                setCurrentDataType(DataType.MEMORY);
                break;
            case 3:
                setCurrentDataType(DataType.DB);
                break;
        }

    }

}
