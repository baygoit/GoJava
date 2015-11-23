package ua.com.goit.gojava7.salivon.state;

import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStatePreloading;

public class PreloadingState extends State {

    public PreloadingState() {
        handler = new ErrorHandlerStatePreloading();
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
    public void changeState(Console context) {
        int inDateToInt = Integer.parseInt(getInData());
        selectCurrentData(inDateToInt);
        context.setCurrentState(new WelcomeState());
    }

    protected void selectCurrentData(int inData) {
        if (inData == FILE_DATA) {
            setCurrentData(FILE_DATA);
        }
        if(inData == OBJECT_DATA) {
            setCurrentData(OBJECT_DATA);
        }
        if(inData == DB_DATA) {
            setCurrentData(DB_DATA);
        }
    }

}
