package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.MainPageController;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public class App {

    public static void main(String[] args) {
        start(initDataType(args));
    }

    public static void start(DataType dataType) {  

        MainPage page = new MainPage(System.out);
        MainPageController controller = new MainPageController(page, dataType, System.in);
        controller.showMainPage();

    }

    private static DataType initDataType(String[] args) {
        DataType dataType = DataType.MEMORY;
        for (String param : args) {
            if (param.equals("m")) {
                dataType = DataType.MEMORY;
            } else if (param.equals("f")) {
                dataType = DataType.FILE;
            }
        }
        
        System.out.println("Kickstarter runs in " + dataType + " mode");
        System.out.println("Run with 'm' to work in "  + DataType.MEMORY + " mode");
        System.out.println("Run with 'f' to work in "  + DataType.FILE + " mode");
        return dataType;
    }

}
