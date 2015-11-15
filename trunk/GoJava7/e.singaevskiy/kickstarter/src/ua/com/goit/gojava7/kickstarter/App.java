package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.MainPageController;
import ua.com.goit.gojava7.kickstarter.dao.DataType;
import ua.com.goit.gojava7.kickstarter.view.MainPage;

public class App {

    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        DataType dataType = DataType.MEMORY;
        for (String param : args) {
            if (param.equals("m")) {
                dataType = DataType.MEMORY;
            } else if (param.equals("f")) {
                dataType = DataType.FILE;
            }
        }

        MainPage page = new MainPage(System.out);
        MainPageController controller = new MainPageController(page, dataType, System.in);
        controller.showMainPage();

    }

}
